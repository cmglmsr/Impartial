package com.site.news.repositories;

import com.site.news.model.NewsArticle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsArticleRepo extends JpaRepository<NewsArticle, Long> {
    List<NewsArticle> findAllByOrderByPublishDate(Pageable newsPage);
}
