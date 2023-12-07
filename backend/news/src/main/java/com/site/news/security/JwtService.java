package com.site.news.security;

import com.site.news.model.BaseEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtService {

    public static final String SECRET = "uZp8nLvT3uH9bw9WfMZkPw-7Tc7w6LOjzJLmP5HrCEwWg5IeJ6G4FGonEXt8yEg0dSrh9w76fUqzgMbTW2fGTeGgUoLfKl3FgK2Lz9x0Ig3zFh5XtMg5RtKlGzOi-2";

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;

    public String generateAccessToken(BaseEntity user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getMail()))
                .setIssuer("News")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey((SECRET.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
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
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String subClaim = claims.getSubject();
            String[] parts = subClaim.split(",");
            if (parts.length == 2) {
                return parts[1];
            }
        } catch (ExpiredJwtException ex) {
            System.out.println("JWT expired: " + ex.getMessage());
        }

        return null;
    }
}
