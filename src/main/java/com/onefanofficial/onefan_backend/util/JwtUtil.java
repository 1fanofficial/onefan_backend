package com.onefanofficial.onefan_backend.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class JwtUtil {

    @Value("${jwtSecret}")
    private String SECRET_KEY;

    private SecretKey key;

    // Initialize the key after properties are loaded
    private SecretKey getSigningKey() {
        if (key == null) {
            // Check if the secret appears to be Base64 encoded
            if (SECRET_KEY.matches("^[A-Za-z0-9+/=_-]+$")) {
                try {
                    // Try to decode it as Base64
                    byte[] keyBytes = this.SECRET_KEY.getBytes(StandardCharsets.UTF_8);
                    return Keys.hmacShaKeyFor(keyBytes);
                } catch (Exception e) {
                    System.out.println("failed");
                    // If decoding fails, use it as a raw string
                }
            }

            // Use as a raw string
            key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        }
        return key;
    }

    public UUID extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return UUID.fromString(claims.getSubject());
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


}