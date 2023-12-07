package com.site.news.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("User")
public class User extends BaseEntity {
    @ManyToMany
    @JoinTable(
            name = "liked_news",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "news_article_id"))
    private List<NewsArticle> likedNews;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings = new ArrayList<>();

    public void addLike(NewsArticle news) {
        this.likedNews.add(news);
    }
}
