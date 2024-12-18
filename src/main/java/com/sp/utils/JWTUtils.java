package com.sp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtils {
    private static final String SECRET_KEY="r0zp1dKcnqzPe59M5DsYOmThQG4lwW0XQV25iFSuX6c=";
    // Your secret key (at least 256 bits)

    // Generate a secure key instance
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Token expiration time (e.g., 1 hour)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract claims from JWT
    public Claims extractClaims(String token) {
        return Jwts.parser()  // using parserBuilder in Spring Boot 3 (Spring Security 6)
                .setSigningKey(key) // Use the Key for signing
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Extract the username from JWT token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Check if the token is expired
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Validate the JWT token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

}
