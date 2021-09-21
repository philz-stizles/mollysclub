// package com.devdezyn.mollysclub.auth.token;

// import com.google.common.net.HttpHeaders;
// import io.jsonwebtoken.security.Keys;
// import lombok.extern.slf4j.Slf4j;

// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import javax.crypto.SecretKey;

// @Slf4j
// @Configuration
// @ConfigurationProperties(prefix = "app.jwt")
// public class JwtConfig{
//     private String secretKey;
//     private Integer tokenExpirationAfterMins; // 15 mins
//     private String tokenPrefix;
//     private String headerString;
//     private String signupUrl;

//     public JwtConfig() {
//     }

//     public String getSecretKey() {
//         log.info(secretKey);
//         return secretKey;
//     }

//     public void setSecretKey(String secretKey) {
//         log.info(secretKey);
//         this.secretKey = secretKey;
//     }

//     public Integer getTokenExpirationAfterMins() {
//         return tokenExpirationAfterMins;
//     }

//     public void setTokenExpirationAfterMins(Integer tokenExpirationAfterMins) {
//         this.tokenExpirationAfterMins = tokenExpirationAfterMins;
//     }

//     public String getTokenPrefix() {
//         return tokenPrefix;
//     }

//     public void setTokenPrefix(String tokenPrefix) {
//         this.tokenPrefix = tokenPrefix;
//     }

//     public String getHeaderString() {
//         return headerString;
//     }

//     public void setHeaderString(String headerString) {
//         this.headerString = headerString;
//     }

//     public String getSignupUrl() {
//         return signupUrl;
//     }

//     public void setSignupUrl(String signupUrl) {
//         this.signupUrl = signupUrl;
//     }

//     @Bean
//     public SecretKey getSecretKeyForSigning() {
//         return Keys.hmacShaKeyFor(secretKey.getBytes());
//     }

//     public String getAuthorizationHeaders() {
//         return HttpHeaders.AUTHORIZATION;
//     }
// }
