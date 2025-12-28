package com.codewithmosh.store.services;

import com.codewithmosh.store.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class JwtService {
    private final JwtConfig jwtConfig;

    public String generateAccessToken(Long id, String name, String email) {
        return generateToken(id, name, email, jwtConfig.getAccessTokenExpiration());
    }

    public String generateRefreshToken(Long id, String name, String email) {
        return generateToken(id, name, email, jwtConfig.getRefreshTokenExpiration());
    }

    private String generateToken(Long id, String name, String email, long tokenExpiration) {
        return Jwts.builder()
                .subject(id.toString())
                .claim("name", name)
                .claim("email", email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * tokenExpiration))
                .signWith(jwtConfig.getSecretKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            var claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        }catch(JwtException _) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(jwtConfig.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public String getUserIdFromToken(String token) {
        return getClaims(token).getSubject();
    }
}
