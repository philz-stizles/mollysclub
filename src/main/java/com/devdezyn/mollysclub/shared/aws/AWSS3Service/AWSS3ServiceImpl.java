package com.devdezyn.mollysclub.shared.aws.AWSS3Service;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AWSS3ServiceImpl implements AWSS3Service {
    @Value("${app.aws.s3.bucket-name}")
    private String bucketName;

    @Value("${app.aws.s3.service-url}")
    private String serviceUrl;

    @Value("${app.aws.s3.application-folder}")
    private String applicationFolder;

    private final AmazonS3 amazonS3Client;

    public String upload(MultipartFile file) {
        //get file metadata
        ObjectMetadata objectMetadata = getMetaData(file);

        //Save Image in S3 and then save Todo in the database
        String fileName = String.format("%s-%s", UUID.randomUUID(), file.getOriginalFilename());

        String path = String.format("%s/%s", bucketName, applicationFolder);

        try {
            amazonS3Client.putObject(path, fileName, file.getInputStream(), objectMetadata);
            amazonS3Client.setObjectAcl(path, fileName, CannedAccessControlList.PublicRead);
            log.info("File Uploaded successfully");
        } catch (AmazonServiceException ase) {
            log.error("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            log.error("Error Message:    " + ase.getMessage());
            log.error("HTTP Status Code: " + ase.getStatusCode());
            log.error("AWS Error Code:   " + ase.getErrorCode());
            log.error("Error Type:       " + ase.getErrorType());
            log.error("Request ID:       " + ase.getRequestId());
            throw ase;
        } catch (AmazonClientException clientException) {
            // throw new IllegalStateException("Failed to upload the file", e);
            log.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format("%s/%s/%s", serviceUrl, path, fileName);
    }
    
    public void deleteFile(String bucketName, String fileName) {
        amazonS3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
        log.info(fileName + " deleted");
    }

    public String getPublicDownloadUrl(String bucketName, String fileName) {
        amazonS3Client.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);
        URL url = amazonS3Client.getUrl(bucketName, fileName);
        return url.toString();
    }

    public String getPreSignedDownloadUrl(String bucketName, String fileName) {

        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60; //1 HR expiration time
        expiration.setTime(expTimeMillis);
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileName)
                .withMethod(HttpMethod.GET).withExpiration(expiration);
        URL url = amazonS3Client.generatePresignedUrl(generatePresignedUrlRequest);
        log.info("Pre-signed URL found for " + fileName);
        return url.toString();
    }


    public byte[] download(String key) {
        try {
            final S3Object s3Object = amazonS3Client.getObject(bucketName, key);
            final S3ObjectInputStream s3ObjectStream = s3Object.getObjectContent();
            byte[] content = IOUtils.toByteArray(s3ObjectStream);

            s3Object.close();

            return content;

        } catch (AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed to download the file", e);
        } 
    }

    private ObjectMetadata getMetaData(MultipartFile file) {
         Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(file.getSize());
        metadata.forEach(objectMetadata::addUserMetadata);

        return objectMetadata;
    }

}
