package com.devdezyn.mollysclub.shared.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class SmsRequest {
    @NotBlank
    private final String phoneNumber; // destination
    @NotBlank
    private final String message;
    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;

    }
    
    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
