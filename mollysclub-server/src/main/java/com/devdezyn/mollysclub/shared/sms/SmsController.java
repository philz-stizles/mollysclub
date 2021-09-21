package com.devdezyn.mollysclub.shared.sms;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
// @CrossOrigin("*")
@RequestMapping("/api/v1/sms")
public class SmsController {
    private final SmsService smsService;

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest);
    }
}
