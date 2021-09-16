package com.devdezyn.mollysclub.auth.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider implements Serializable {
    @Value("${app.jwt.secretKey}")
    private String jwtSecret;

    @Value("${app.jwt.tokenExpirationAfterMins}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication, String issuer) {

        User user = (User) authentication.getPrincipal();
        var roles = user.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Date issuedAt = new Date();
        log.info(String.valueOf(jwtExpirationInMs));
        Date expiryDate = new Date(issuedAt.getTime() + (10 * 60 * 1000)); // jwtExpirationInMs);
        // Date expiryDate = new Date(System.currentTimeMillis() + (10 * 60 * 1000))

        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        Key key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder()
                .setSubject(user.getUsername())
                // .setSubject(Long.toString(user.getId()))
                .claim("roles", roles)
                .setIssuer(issuer)
                .setIssuedAt(issuedAt)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }
    
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecret).build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts
                .parserBuilder()
                .setSigningKey(jwtSecret).build()
                    .parseClaimsJws(authToken);
                
            return true;
        } catch (SecurityException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
