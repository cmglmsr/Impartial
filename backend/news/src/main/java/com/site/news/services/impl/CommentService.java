package com.site.news.services.impl;

import com.site.news.model.Comment;
import com.site.news.model.NewsArticle;
import com.site.news.model.User;
import com.site.news.repositories.CommentRepo;
import com.site.news.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final UserRepo userRepo;

    public CommentService(CommentRepo commentRepo, UserRepo userRepo) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
    }


    public void comment(NewsArticle newsArticle, String commentText, User user) throws Exception {
        if(commentText != null) {
            Comment newComment = new Comment(null, commentText, user, newsArticle);
            commentRepo.save(newComment);
        }
    }

    public List<Comment> findAllCommentsByUser(String email) {
        return commentRepo.findAllByUser(userRepo.findByMail(email));

    }

}