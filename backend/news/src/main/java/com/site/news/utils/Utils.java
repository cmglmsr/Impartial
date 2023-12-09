package com.site.news.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class Utils {
    public static String checkAuth(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        if (Objects.equals(email, "anonymousUser")) {
            return null;
        }
        else {
            return email;
        }
    }
}
