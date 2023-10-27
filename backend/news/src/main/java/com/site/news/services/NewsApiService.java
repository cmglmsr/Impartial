package com.site.news.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NewsApiService {
    public void getNews() {
        WebClient client = WebClient.create();
        // TODO: Add paramters to get news for customized news lookup and save the incoming news to database
        // TODO: Add a system to get all the pages of the retrieved news

        /*String responseSpec = client.get()
                .uri("https://newsdata.io/api/1/news?timeframe=20m&apikey=")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responseSpec);*/


    }
}
