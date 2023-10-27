package com.site.news;

import com.site.news.services.NewsApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NewsApiScheduler {
    private final NewsApiService newsApiService;

    public NewsApiScheduler(NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    @Scheduled(cron = "0 */20 * ? * *")
    public void getNews() {
        newsApiService.getNews();
    }

}
