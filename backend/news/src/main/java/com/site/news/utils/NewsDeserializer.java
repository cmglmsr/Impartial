package com.site.news.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.site.news.model.NewsArticle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NewsDeserializer extends StdDeserializer<NewsArticle> {
    protected NewsDeserializer() {
        super(NewsArticle.class);
    }

    protected NewsDeserializer(Class<?> vc) {
        super(vc);
    }

    protected NewsDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected NewsDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public NewsArticle deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        String source = node.get("source").get("name").asText();
        String creator = node.get("author").asText();
        String title = node.get("title").asText();
        String description = node.get("description").asText();
        //String link = node.get("url").asText();
        String img = node.get("urlToImage").asText();
        String content = node.get("content").asText();
        String date = node.get("publishedAt").asText();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime publishDate = LocalDateTime.parse(date, inputFormatter);
        return new NewsArticle(null, source, creator, title, description, img, content, publishDate, null,null, null, null);
    }
}
