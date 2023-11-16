package com.site.news.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.news.model.NewsArticle;
import com.site.news.repositories.NewsArticleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class NewsApiService {
    private final NewsArticleRepo newsArticleRepo;

    public NewsApiService(NewsArticleRepo newsArticleRepo) {
        this.newsArticleRepo = newsArticleRepo;
    }

    public void getNews() throws JsonProcessingException {
        WebClient client = WebClient.create();
        // TODO: Add paramters to get news for customized news lookup
        // TODO: Add a system to get all the pages of the retrieved news
        LocalDate today = LocalDate.now();
        String yesterday = (today.minusDays(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String uri = String.format("https://newsapi.org/v2/everything?q=politics&from=%s&language=en&apiKey=148f7787454b4618b7d61f11fb4158ef", yesterday);

        String responseSpec = client.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        log.info("Api consumed successfully on {}", today);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonNode actualObj = mapper.readTree(responseSpec);
        String results = actualObj.get("articles").toString();
        List<NewsArticle> listNews = mapper.readValue(results, new TypeReference<>() {
        });
        newsArticleRepo.saveAll(listNews);
        log.info("Data saved successfully on {}", today);





    }
}
