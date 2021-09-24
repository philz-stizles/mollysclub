package com.devdezyn.mollysclub.shared.sms.twilio;

import com.twilio.Twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class TwilioInitializer {

  private final TwilioConfig twilioConfig;
    
    @Autowired
    public TwilioInitializer(TwilioConfig twilioConfiguration) {
        this.twilioConfig = twilioConfiguration;
        
        Twilio.init(
                twilioConfig.getAccountSid(),
                twilioConfig.getAuthToken()
        );
        
        log.info(".. Twilio initialized");
    }
}
