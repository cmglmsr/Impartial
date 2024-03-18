package com.site.news.services.impl;

import com.site.news.model.Comment;
import com.site.news.model.NewsArticle;
import com.site.news.model.Rating;
import com.site.news.model.User;
import com.site.news.repositories.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }


    public void comment(NewsArticle newsArticle, String commentText, User user) throws Exception {
        if(commentText != null) {
            Comment newComment = new Comment(null, commentText, user, newsArticle);
            commentRepo.save(newComment);
        }
    }
}