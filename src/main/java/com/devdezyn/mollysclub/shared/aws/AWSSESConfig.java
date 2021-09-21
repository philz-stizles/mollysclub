package com.devdezyn.mollysclub.shared.aws;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSSESConfig {
    @Value("${app.aws.access-key}")
    private String accessKey;

    @Value("${app.aws.secret-key}")
    private String secretKey;

     @Value("${app.aws.region}")
    private String region;

    public AWSStaticCredentialsProvider awsCredentials() {
        BasicAWSCredentials credentials =
                new BasicAWSCredentials(accessKey, secretKey);
        return new AWSStaticCredentialsProvider(credentials);
    }

    @Bean
    public AmazonSimpleEmailService getAmazonSimpleEmailService() {
        return AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(awsCredentials())
                .withRegion(region).build();
    }
}