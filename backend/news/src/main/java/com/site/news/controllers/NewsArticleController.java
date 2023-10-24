package com.site.news.controllers;

import com.site.news.model.NewsArticle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.site.news.services.NewsArticleService;

import java.util.List;

@RestController
@RequestMapping("/news-article")
public class NewsArticleController {
    private final NewsArticleService newsArticleService;

    public NewsArticleController(NewsArticleService newsArticleService) {
        this.newsArticleService = newsArticleService;
    }
    // Create
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody NewsArticle newsArticle) {
        return new ResponseEntity<>(newsArticleService.create(newsArticle), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<?> batchCreate(@RequestBody List<NewsArticle> newsArticles) {
        return new ResponseEntity<>(newsArticleService.batchCreate(newsArticles), HttpStatus.CREATED);
    }

    // Retrieve
    @GetMapping("/{id}")
    public ResponseEntity<?> retrieve(@PathVariable Long id) {
        return new ResponseEntity<>(newsArticleService.retrieve(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> retrieveAll() {
        return new ResponseEntity<>(newsArticleService.retrieveAll(), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        newsArticleService.delete(id);
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAll() {
        newsArticleService.deleteAll();
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }

}