package com.devdezyn.mollysclub.shared.sms;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SmsService {
  private final SmsSender smsSender;

  public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
  }

}
