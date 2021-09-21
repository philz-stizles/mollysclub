package com.devdezyn.mollysclub.auth.services;

import io.jsonwebtoken.Claims;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Component
public interface JwtTokenService {
   String generateToken(Authentication authentication, String issuer);
    
   <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);
    
   Date getExpirationFromToken(String token);

   List<String> getRolesFromToken(String token);

   String getUserFromToken(String token);

   boolean validateToken(String token);
}
