package com.site.news.services.impl;

import com.site.news.model.NewsArticle;
import com.site.news.model.User;
import com.site.news.repositories.BaseEntityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.site.news.utils.Utils.checkAuth;

@Service
public class UserService {

    private final BaseEntityRepo baseEntityRepo;

    public UserService(BaseEntityRepo baseEntityRepo) {
        this.baseEntityRepo = baseEntityRepo;
    }

    public List<NewsArticle> findAllBookmarksOfUser() {
        String mail = checkAuth();
        User user = (User) baseEntityRepo.findByMail(mail);
        return user.getLikedNews();
    }
}
