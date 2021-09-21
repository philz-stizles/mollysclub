package com.devdezyn.mollysclub.shared.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSS3Config {

    @Value("${app.aws.access-key}")
    private String accessKey;

    @Value("${app.aws.secret-key}")
    private String secretKey;

     @Value("${app.aws.region}")
    private String region;

    @Bean
    public AmazonS3 s3() {
        final AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}