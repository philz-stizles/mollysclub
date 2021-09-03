package com.devdezyn.mollysclub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthJwtConfig {
    @Value("${mollysclub.jwt.tokenExpirationAfterMins}")
    Number tokenExpirationAfterMins;

    @Value("${mollysclub.jwt.tokenPrefix}")
    String tokenPrefix;

    @Value("${mollysclub.jwt.headerString}")
    String headerString;

    @Value("${mollysclub.jwt.signupUrl}")
    String signupUrl;
}