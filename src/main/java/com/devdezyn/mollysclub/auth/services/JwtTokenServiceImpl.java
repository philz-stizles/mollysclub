package com.devdezyn.mollysclub.auth.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.devdezyn.mollysclub.auth.models.UserPrincipal;

@Slf4j
@Service
public class JwtTokenServiceImpl implements JwtTokenService, Serializable {
    public static final String ROLES = "roles";

    @Value("${app.jwt.secretKey}")
    private String jwtSecret;

    @Value("${app.jwt.tokenExpirationAfterMins}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication, String issuer) {

        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        final List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        log.error("UUser principal: {}", userDetails.toString());
        log.error("Token expires in {} mins", jwtExpirationInMs);
        // Date expiryDate = new Date(issuedAt.getTime() + (jwtExpirationInMs * 60 * 1000)); // jwtExpirationInMs);
        // Date expiryDate = new Date(System.currentTimeMillis() + (10 * 60 * 1000))
        final Map<String, Object> claims = new HashMap<>();
        claims.put(ROLES, roles);
        return doGenerateToken(claims, userDetails.getEmail(), issuer);
    }
    
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, claims -> claims.getExpiration());
    }

    public List<String> getRolesFromToken(String token) {
        return getClaimFromToken(token, claims -> (List) claims.get(ROLES));
    }

    public String getUserFromToken(String token) {
        return getClaimFromToken(token, claims -> claims.getSubject());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject, String issuer) {
        log.error("UUser email: {}", subject);
        final long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expiryDate = new Date(now + (jwtExpirationInMs * 60 * 1000));
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        Key key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setIssuer(issuer)
                .setIssuedAt(issuedAt)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
            return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationFromToken(token);
		return expiration.before(new Date());
	}

    // public Long getUserIdFromJWT(String token) {
    //     Claims claims = Jwts.parserBuilder()
    //             .setSigningKey(jwtSecret).build()
    //             .parseClaimsJws(token)
    //             .getBody();

    //     return Long.parseLong(claims.getSubject());
    // }
    
    // public String getUsernameFromJWT(String token) {
    //     Claims claims = Jwts.parserBuilder()
    //             .setSigningKey(jwtSecret).build()
    //             .parseClaimsJws(token)
    //             .getBody();

    //     return claims.getSubject();
    // }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();
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
