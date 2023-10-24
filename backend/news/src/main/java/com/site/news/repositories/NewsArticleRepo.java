package com.site.news.repositories;

import com.site.news.model.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsArticleRepo extends JpaRepository<NewsArticle, Long> {

}
