package com.site.news.services.impl;

import com.site.news.model.NewsArticle;
import com.site.news.model.Rating;
import com.site.news.model.User;
import com.site.news.repositories.RatingRepo;
import com.site.news.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepo ratingRepo;
    private final UserRepo userRepo;

    public RatingService(RatingRepo ratingRepo, UserRepo userRepo) {
        this.ratingRepo = ratingRepo;
        this.userRepo = userRepo;
    }

    public List<Rating> findAllRatingByUser(String email) {
       return ratingRepo.findAllByUser(userRepo.findByMail(email));

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

    public void removeRate(NewsArticle newsArticle, User user) throws Exception {
        Rating oldRating = ratingRepo.findByUserAndNewsArticle(user, newsArticle);
        if(oldRating == null) {
            throw new Exception("Rating doesn't exist");
        }
        else {
            ratingRepo.delete(oldRating);
        }
    }
}
