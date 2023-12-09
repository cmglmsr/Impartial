package com.site.news.services.impl;

import com.site.news.model.User;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.repositories.NewsArticleRepo;
import com.site.news.model.NewsArticle;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static com.site.news.utils.Utils.checkAuth;

@Service
public class NewsArticleService {
    private final NewsArticleRepo newsArticleRepo;
    private final BaseEntityRepo baseEntityRepo;
    private final RatingService ratingService;
    public NewsArticleService(NewsArticleRepo newsArticleRepo, BaseEntityRepo baseEntityRepo, RatingService ratingService) {
        this.newsArticleRepo = newsArticleRepo;
        this.baseEntityRepo = baseEntityRepo;
        this.ratingService = ratingService;
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

}
