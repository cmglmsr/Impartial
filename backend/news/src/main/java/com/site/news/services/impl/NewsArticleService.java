package com.site.news.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.news.model.User;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.repositories.NewsArticleRepo;
import com.site.news.model.NewsArticle;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static com.site.news.utils.Utils.checkAuth;

@Service
public class NewsArticleService {
    private final NewsArticleRepo newsArticleRepo;
    private final BaseEntityRepo baseEntityRepo;
    private final RatingService ratingService;
    private final CommentService commentService;
    public NewsArticleService(NewsArticleRepo newsArticleRepo, BaseEntityRepo baseEntityRepo, RatingService ratingService, CommentService commentService) {
        this.newsArticleRepo = newsArticleRepo;
        this.baseEntityRepo = baseEntityRepo;
        this.ratingService = ratingService;
        this.commentService = commentService;
    }

    //Create

    public NewsArticle create(NewsArticle newsArticle) {
        return newsArticleRepo.save(newsArticle);
    }

    public  List<NewsArticle> batchCreate(List<NewsArticle> newsArticle) {
        return newsArticleRepo.saveAll(newsArticle);
    }

    // Retrieve

    public Optional<NewsArticle> retrieve(Long id) {
        return newsArticleRepo.findById(id);
    }

    public  List<NewsArticle> retrieveAll(int pageNum, int pageSize) {
        Pageable newsPage = PageRequest.of(pageNum, pageSize);
        List<NewsArticle> allArticles = newsArticleRepo.findAll(newsPage).toList();
        return allArticles;

    }

    // Update

    // Delete
    public void delete(Long id) {
        newsArticleRepo.deleteById(id);
    }

    public void deleteAll() {
        newsArticleRepo.deleteAll();
    }

    public void bookmarkNewsArticle(long id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!Objects.equals(auth.getName(), "anonymousUser")) {

            NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                    () -> new Exception("News Article with given id " + id + " does not exist"));

            User user = (User) baseEntityRepo.findByMail(auth.getName());
            if (user == null) {
                throw new Exception("User with given email " + auth.getName() + " does not exist");
            }
            if (user.getLikedNews().contains(newsArticle)) {
                throw new Exception("User already bookmarked the post with id " + newsArticle.getId());

            }
            user.addBookmark(newsArticle);
            baseEntityRepo.save(user);
        }
        else {
            throw new Exception("User not authenticated to perform this operation");
        }
    }

    public void removeBookmark(long id) throws Exception {
        String email = checkAuth();
        if(email == null){
            throw new Exception("User not authenticated to perform this operation");
        }
        NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                () -> new Exception("News Article with given id " + id + " does not exist"));

        User user = (User) baseEntityRepo.findByMail(email);
        if (user == null) {
            throw new Exception("User with given email " + email+ " does not exist");
        }
        if (!user.getLikedNews().contains(newsArticle)) {
            throw new Exception("User does not have a bookmark to remove for the post with id " + id);

        }
        user.removeBookmark(newsArticle);
        baseEntityRepo.save(user);

    }

    public void rateNewsArticle(long id, int ratingScore) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!Objects.equals(auth.getName(), "anonymousUser")) {
            NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                    () -> new Exception("News Article with given id " + id + " does not exist"));

            User user = (User) baseEntityRepo.findByMail(auth.getName());
            if(user == null){
                throw new Exception("User with given email " + auth.getName() + " does not exist");
            }
            ratingService.rate(newsArticle, ratingScore, user);
        }
        else {
            throw new Exception("User not authenticated to perform this operation");
        }

    }

    public void removeRating(long id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!Objects.equals(auth.getName(), "anonymousUser")) {
            NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                    () -> new Exception("News Article with given id " + id + " does not exist"));

            User user = (User) baseEntityRepo.findByMail(auth.getName());
            if(user == null){
                throw new Exception("User with given email " + auth.getName() + " does not exist");
            }
            ratingService.removeRate(newsArticle, user);
        }
        else {
            throw new Exception("User not authenticated to perform this operation");
        }

    }

    public void addComment(long id, String comment) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!Objects.equals(auth.getName(), "anonymousUser")) {
            NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                    () -> new Exception("News Article with given id " + id + " does not exist"));

            User user = (User) baseEntityRepo.findByMail(auth.getName());
            if(user == null){
                throw new Exception("User with given email " + auth.getName() + " does not exist");
            }
            commentService.comment(newsArticle, comment, user);
        }
        else {
            throw new Exception("User not authenticated to perform this operation");
        }
    }

    public void generateArticle(String articleBody, String currentAlignment, String targetAlignment) throws JsonProcessingException {
        WebClient client = WebClient.create();
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = "{\n" +
                "    \"inputs\": \"<s>[INST] Rewrite the following" + currentAlignment +"-biased article into "+ targetAlignment +"-biased format:" + articleBody+"[/INST] \",\n" +
                "    \"parameters\": {\n" +
                "        \"max_new_tokens\": 256,\n" +
                "        \"top_p\": 0.9,\n" +
                "        \"temperature\": 0.6,\n" +
                "        \"decoder_input_details\": true,\n" +
                "        \"details\": true\n" +
                "    }\n" +
                "}";

        String genuri = "https://ubt1dljjm9.execute-api.eu-central-1.amazonaws.com/nisa123";
        String genresp = client.post()
                .uri(genuri)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        JsonNode genrespobj = mapper.readTree(genresp);
        String gentext = genrespobj.toString();
        System.out.println(gentext);
        //Todo: finish the api
    }

}
