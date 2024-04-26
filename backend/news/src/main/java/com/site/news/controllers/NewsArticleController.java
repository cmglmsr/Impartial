package com.site.news.controllers;

import com.site.news.model.NewsArticle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.site.news.services.impl.NewsArticleService;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/bookmark/{id}")
    public  ResponseEntity<?> bookmarkNews(@PathVariable Long id){
        try {
            newsArticleService.bookmarkNewsArticle(id);
            return new ResponseEntity<>("Bookmark added", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/bookmark/{id}")
    public  ResponseEntity<?> removeBookmark(@PathVariable Long id){
        try {
            newsArticleService.removeBookmark(id);
            return new ResponseEntity<>("Bookmark removed", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/rate/{id}")
    public ResponseEntity<?> rateNews(@PathVariable Long id, @RequestBody Map<String,String> json){
        int rating = Integer.parseInt(json.get("rating"));
        try {
            newsArticleService.rateNewsArticle(id, rating);
            return new ResponseEntity<>("Rating added", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/rate/{id}")
    public ResponseEntity<?> removeRate(@PathVariable Long id){
        try {
            newsArticleService.removeRating(id);
            return new ResponseEntity<>("Rating removed", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/comment/{id}")
    public ResponseEntity<?> addComment(@PathVariable Long id, @RequestBody Map<String,String> json){
        String comment = json.get("comment");
        try {
            newsArticleService.addComment(id, comment);
            return new ResponseEntity<>("Comment added", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
