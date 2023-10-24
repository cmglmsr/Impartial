package com.site.news.model;

import com.site.news.enums.PoliticalAlignment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String articleBody;
    private String articleSummary;
    private String articleAuthor;
    private String articleSource;
    private Date articleDate;
    private double confidence;
    @Enumerated(value = EnumType.STRING)
    private PoliticalAlignment alignment;
}
