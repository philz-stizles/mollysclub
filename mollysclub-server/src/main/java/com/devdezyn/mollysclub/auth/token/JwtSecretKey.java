// package com.devdezyn.mollysclub.auth.token;

// import io.jsonwebtoken.security.Keys;
// import lombok.extern.slf4j.Slf4j;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import javax.crypto.SecretKey;

// @Slf4j
// @Configuration
// public class JwtSecretKey {
//     private final JwtConfig jwtConfig;

//     @Autowired
//     public JwtSecretKey(JwtConfig jwtConfig) {
//         this.jwtConfig = jwtConfig;
//     }

//     @Bean
//     SecretKey secretKey() {
//         log.info("In SecretKey Bean {}", jwtConfig.getSecretKey());
//         return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
//     }

// }
