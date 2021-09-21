package com.devdezyn.mollysclub.shared.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthJwtConfig {
    @Value("${app.jwt.tokenExpirationAfterMins}")
    Number tokenExpirationAfterMins;

    @Value("${app.jwt.tokenPrefix}")
    String tokenPrefix;

    @Value("${app.jwt.headerString}")
    String headerString;

    @Value("${app.jwt.signupUrl}")
    String signupUrl;
}