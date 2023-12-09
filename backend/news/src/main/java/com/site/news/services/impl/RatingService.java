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

    public RatingService(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }


    public void rate(NewsArticle newsArticle, int rating, User user) throws Exception {
        Rating oldRating = ratingRepo.findByUserAndNewsArticle(user, newsArticle);
        if(oldRating == null) {
            Rating newRating = new Rating(null, rating, user, newsArticle);
            ratingRepo.save(newRating);
        }
        else {
            oldRating.setRating(rating);
            ratingRepo.save(oldRating);
        }
    }
}
