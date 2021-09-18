package com.devdezyn.mollysclub.auth.security;

import com.devdezyn.mollysclub.auth.services.JwtTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenProvider;
    // private final JwtConfig jwtConfig;
    // private final SecretKey secretKey;

    // public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
    //     this.authenticationManager = authenticationManager;
    // }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
            log.info("User {} is trying to authenticate", authenticationRequest.getUsername());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            return authentication;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {
                // User user = (User) authentication.getPrincipal();
                // var roles = user.getAuthorities()
                //     .stream()
                //     .map(GrantedAuthority::getAuthority)
                //         .collect(Collectors.toList());
                    
                String issuer = request.getRequestURI().toString();
                String accessToken = jwtTokenProvider.generateToken(authentication, issuer);


                String refreshToken = jwtTokenProvider.generateToken(authentication, issuer);

                // response.addHeader(jwtConfig.getAuthorizationHeaders(), jwtConfig.getTokenPrefix() + accessToken);
                // response.addHeader("refresh_token", refreshToken);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", accessToken);
                tokens.put("refreshToken", refreshToken);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
    
    // @Override
    // protected void unSuccessAuthentication(HttpServletRequest request, HttpServletResponse response
    //         HttpServletRequest request, HttpServletResponse response, FilterChain chain,
    //         Authentication authentication) throws IOException, ServletException {
    //     String token = Jwts.builder()
    //             .setSubject(authResult.getName())
    //     .claim("authorities", authResult.getAuthorities())
    //     .setIssuedAt(new Date())
    //     .setExpiration(java.sql.Date.valueOf(LocalDate.now()))
    //     .signWith(secretKey)
    //     .compact();

    //     response.addHeader(jwtConfig.getAuthorizationHeaders(), jwtConfig.getTokenPrefix() + token);
    // }
}
