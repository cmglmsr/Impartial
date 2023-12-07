package com.site.news.security;

import com.site.news.model.BaseEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    public static final String SECRET = "uZp8nLvT3uH9bw9WfMZkPw-7Tc7w6LOjzJLmP5HrCEwWg5IeJ6G4FGonEXt8yEg0dSrh9w76fUqzgMbTW2fGTeGgUoLfKl3FgK2Lz9x0Ig3zFh5XtMg5RtKlGzOi-2";
//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJudWxsLGFiY0BnbWFpbC5jb20iLCJpc3MiOiJOZXdzIiwiaWF0IjoxNzAxOTYxMDg0LCJleHAiOjE3MDIwNDc0ODR9.4PXQamYgIV-3rb1MOgzWSk77_ogOwrTXwFLAMZ6GyvfP_9aP2v-dhHtXFCEvVCZaxY6Xa0kzVWIQ1-KOt7D1xA
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;

    private Key getSigningKey() {
        byte[] keyBytes = SECRET.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(BaseEntity user) {
        String token = Jwts.builder()
                .setSubject(String.format("%s", user.getMail()))
                .setIssuer("News")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(getSigningKey())
                .compact();

        return token;
    }

    public boolean validateAccessToken(String token) {
        try {
            JwtParser jwtParser = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build();
            Claims claims = jwtParser.parseClaimsJws(token).getBody();

            return true;
        } catch (ExpiredJwtException ex) {
            System.out.println("JWT expired: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("Token is null, empty, or only whitespace: " + ex.getMessage());
        } catch (MalformedJwtException ex) {
            System.out.println("JWT is invalid: " + ex);
        } catch (UnsupportedJwtException ex) {
            System.out.println("JWT is not supported: " + ex);
        }

        return false;
    }


    public String extractUserEmail(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
                return claims.getSubject();

        } catch (ExpiredJwtException ex) {
            System.out.println("JWT expired: " + ex.getMessage());
        }

        return null;
    }
}
