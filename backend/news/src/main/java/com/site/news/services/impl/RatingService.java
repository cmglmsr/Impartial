package com.site.news.services.impl;

import com.site.news.model.NewsArticle;
import com.site.news.model.Rating;
import com.site.news.model.User;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.repositories.NewsArticleRepo;
import com.site.news.repositories.RatingRepo;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepo ratingRepo;
    private final BaseEntityRepo baseEntityRepo;
    private final NewsArticleRepo newsArticleRepo;

    public RatingService(RatingRepo ratingRepo, BaseEntityRepo baseEntityRepo, NewsArticleRepo newsArticleRepo) {
        this.ratingRepo = ratingRepo;
        this.baseEntityRepo = baseEntityRepo;
        this.newsArticleRepo = newsArticleRepo;
    }

    public void rate(long articleId, int rating, String explanation) throws Exception {
        long userId = 5; //todo change
        User user = (User)baseEntityRepo.findById(userId).orElseThrow(() -> new Exception(""));
        NewsArticle newsArticle = newsArticleRepo.findById(articleId).orElseThrow(() -> new Exception(""));
        Rating newRating = new Rating(null, rating, explanation, user, newsArticle);
    }
}
