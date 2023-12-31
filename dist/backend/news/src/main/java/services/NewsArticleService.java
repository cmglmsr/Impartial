package services;

import model.NewsArticle;
import org.springframework.stereotype.Service;
import repositories.NewsArticleRepo;

import java.util.List;
import java.util.Optional;

@Service
public class NewsArticleService {
    private final NewsArticleRepo newsArticleRepo;

    public NewsArticleService(NewsArticleRepo newsArticleRepo) {
        this.newsArticleRepo = newsArticleRepo;
    }

    //Create

    public NewsArticle create(NewsArticle newsArticle) {
        return newsArticleRepo.save(newsArticle);
    }

    public  List<NewsArticle> batchCreate(List<NewsArticle> newsArticle) {
        return newsArticleRepo.saveAll(newsArticle);
    }

    // Retrieve

    public Optional<NewsArticle> retrieve(Long id) {
        return newsArticleRepo.findById(id);
    }

    public  List<NewsArticle> retrieveAll() {
        return newsArticleRepo.findAll();
    }

    // Update

    // Delete
    public void delete(Long id) {
        newsArticleRepo.deleteById(id);
    }

    public void deleteAll() {
        newsArticleRepo.deleteAll();
    }
}
