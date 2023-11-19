package com.site.news.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.site.news.utils.NewsDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonDeserialize(using = NewsDeserializer.class)
@Table(name = "news_articles")
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String content;
    /*private Date articleDate;
    private double confidence;
    @Enumerated(value = EnumType.STRING)
    private PoliticalAlignment alignment;*/
}
