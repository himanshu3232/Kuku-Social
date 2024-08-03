package com.kuku.config;

import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
    public String generateToken(Authentication auth){
        String jwt = Jwts.builder()
                .setIssuedAt(new Date()).setExpiration(new Date(
                        new Date().getTime()+86400000
                )).claim("email",auth.getName()).signWith(key).compact();

        return jwt;
    }
    public String getEmailFromToken(String jwt){
        jwt = jwt.substring(7);
        Claims claims = Jwts.parseBuilder().setSigningKey(key).build().
                parseClaimsJws(jwt).getBody();

        return String.valueOf(claims.get("email"));
    }
}