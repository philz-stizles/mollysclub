package com.devdezyn.mollysclub.shared.sms.twilio;

import com.devdezyn.mollysclub.shared.sms.BulkSmsRequest;
import com.devdezyn.mollysclub.shared.sms.SmsRequest;
import com.devdezyn.mollysclub.shared.sms.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private final TwilioConfig twilioConfig;
   
    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            Message createdMessage = creator.create();
            log.info("Send sms {}", createdMessage.getSid());

        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number");
        }
    }
    
    public void sendMessages(BulkSmsRequest bulkSmsRequest) {

        bulkSmsRequest.numbers.stream().forEach(number -> {
            Message message = Message
                    .creator(new PhoneNumber(number), new PhoneNumber(twilioConfig.getNumber()), bulkSmsRequest.message)
                    .create();
            System.out.println("Sent message w/ sid: " + message.getSid());
        });
    }
    
    public void receiveSms(MultiValueMap<String, String> smsCallback) {

    }
    
    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return true;
    }
}
