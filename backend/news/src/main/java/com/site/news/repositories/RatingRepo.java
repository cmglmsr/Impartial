package com.site.news.repositories;
import com.site.news.model.NewsArticle;
import com.site.news.model.Rating;
import com.site.news.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
    Rating findByUserAndNewsArticle(User user, NewsArticle newsArticle);
    List<Rating> findAllByUser(User user);
}
