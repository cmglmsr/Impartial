package com.site.news.model;

import com.site.news.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("User")
public class User extends BaseEntity {
    public User(Long id, @Email(message = "Email should be valid") String mail, String password, UserType type) {
        super(id, mail, password, type);
    }

    @ManyToMany
    @JoinTable(
            name = "liked_news",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "news_article_id"))
    private List<NewsArticle> likedNews;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Rating> ratings = new ArrayList<>();

    public void addLike(NewsArticle news) {
        this.likedNews.add(news);
    }

}
