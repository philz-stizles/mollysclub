package com.devdezyn.mollysclub.shared.sms.twilio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties("app.twilio")
public class TwilioConfig {
    private String accountSid;
    private String authToken;
    private String number;
}