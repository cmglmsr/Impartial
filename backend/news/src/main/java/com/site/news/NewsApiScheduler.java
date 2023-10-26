package com.site.news;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class NewsApiScheduler {

    @Scheduled(cron = "0 * * * * *")
    public void getNews() {
        WebClient client = WebClient.create();

        /*String responseSpec = client.get()
                .uri("https://newsdata.io/api/1/news?timeframe=10&apikey=pub_31923dc36e40eb13b71c2e0c05385ab41b2bd")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responseSpec);*/

    }

}
