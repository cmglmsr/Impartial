package com.site.news.services.impl;

import com.site.news.model.Rating;
import com.site.news.model.User;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.repositories.NewsArticleRepo;
import com.site.news.model.NewsArticle;
import com.site.news.repositories.RatingRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsArticleService {
    private final NewsArticleRepo newsArticleRepo;
    private final BaseEntityRepo baseEntityRepo;
    private final RatingRepo ratingRepo;

    public NewsArticleService(NewsArticleRepo newsArticleRepo, BaseEntityRepo baseEntityRepo, RatingRepo ratingRepo) {
        this.newsArticleRepo = newsArticleRepo;
        this.baseEntityRepo = baseEntityRepo;
        this.ratingRepo = ratingRepo;
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

    public void likeNewsArticle(long id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                () -> new Exception("News Article with given id " + id + " does not exist"));

        User user = (User) baseEntityRepo.findByMail(auth.getName());
        if(user == null){
            throw new Exception("User with given email " + auth.getName() + " does not exist");
        }
        if(user.getLikedNews().contains(newsArticle)){
            throw new Exception("User already liked the post with id " + newsArticle.getId());

        }
        user.addLike(newsArticle);
        baseEntityRepo.save(user);
    }

    public void rateNewsArticle(long id, int ratingScore, String explanation) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NewsArticle newsArticle = newsArticleRepo.findById(id).orElseThrow(
                () -> new Exception("News Article with given id " + id + " does not exist"));

        User user = (User) baseEntityRepo.findByMail(auth.getName());
        if(user == null){
            throw new Exception("User with given email " + auth.getName() + " does not exist");
        }
        Rating rating = new Rating(null, ratingScore, explanation, user, newsArticle);


        ratingRepo.save(rating);
    }

}
