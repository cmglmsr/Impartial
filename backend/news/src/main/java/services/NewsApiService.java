package services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NewsApiService {
    public void getNews() {
        WebClient client = WebClient.create();

        String responseSpec = client.get()
                .uri("https://newsapi.org/v2/everything?q=Apple&from=2023-10-26&sortBy=popularity&apiKey=")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responseSpec);


    }
}
