package com.site.news.services.impl;

import com.site.news.model.NewsArticle;
import com.site.news.model.Rating;
import com.site.news.model.User;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.security.JwtService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.site.news.utils.Utils.checkAuth;

@Service
public class UserService {

    private final BaseEntityRepo baseEntityRepo;
    private final JwtService jwtService;

    public UserService(BaseEntityRepo baseEntityRepo, JwtService jwtService) {
        this.baseEntityRepo = baseEntityRepo;
        this.jwtService = jwtService;
    }

    public List<NewsArticle> findAllBookmarksOfUser() {
        String mail = checkAuth();
        User user = (User) baseEntityRepo.findByMail(mail);
        return user.getLikedNews();
    }

    public List<Rating> findAllRatingsOfUser() {
        String mail = checkAuth();
        User user = (User) baseEntityRepo.findByMail(mail);
        return user.getRatings();
    }

    public boolean checkToken(String token) {
        String parsedToken = "";
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            parsedToken = token.substring(7);
        }
        return jwtService.validateAccessToken(parsedToken);
    }
}
