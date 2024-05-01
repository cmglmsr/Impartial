package com.site.news.repositories;

import com.site.news.model.Comment;
import com.site.news.model.NewsArticle;
import com.site.news.model.Rating;
import com.site.news.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUser(User user);
    List<Comment> findAllByNewsArticle(NewsArticle article);

}
