package com.site.news.controllers;

import com.site.news.NewsApplication;
import com.site.news.services.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/bookmarks")
    public ResponseEntity<?> getBookmarksOfUser() {
        return new ResponseEntity<>(userService.findAllBookmarksOfUser(), HttpStatus.OK);
    }
}
