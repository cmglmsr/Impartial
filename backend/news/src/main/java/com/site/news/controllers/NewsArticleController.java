package com.site.news.controllers;

import com.site.news.model.NewsArticle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.site.news.services.impl.NewsArticleService;

import java.util.List;

@RestController
@RequestMapping("/home/news")
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

    @GetMapping("")
    public ResponseEntity<?> retrieveAll(@RequestParam int pageNum, @RequestParam int pageSize) {
        return new ResponseEntity<>(newsArticleService.retrieveAll(pageNum, pageSize), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        newsArticleService.delete(id);
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAll() {
        newsArticleService.deleteAll();
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }

    //

    @PostMapping("/like/{id}")
    public  ResponseEntity<?> likeNews(@PathVariable Long id) throws Exception {
        newsArticleService.likeNewsArticle(id);
        return new ResponseEntity<>("Liked.", HttpStatus.OK);
    }

}
