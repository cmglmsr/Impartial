package com.site.news.controllers;

import com.site.news.NewsApplication;
import com.site.news.services.impl.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/check-token")
    public ResponseEntity<?> checkToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        try {
        boolean valid = userService.checkToken(token);
            if(valid) {
                return new ResponseEntity<>(valid, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(valid, HttpStatus.UNAUTHORIZED);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/bookmarks")
    public ResponseEntity<?> getBookmarksOfUser() {
        return new ResponseEntity<>(userService.findAllBookmarksOfUser(), HttpStatus.OK);
    }

    @GetMapping("/ratings")
    public ResponseEntity<?> getRatingsOfUser()  {
        return new ResponseEntity<>(userService.findAllRatingsOfUser(), HttpStatus.OK);
    }
}
