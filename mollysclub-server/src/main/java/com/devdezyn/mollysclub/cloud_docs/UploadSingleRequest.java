package com.devdezyn.mollysclub.cloud_docs;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Getter
@Setter
public class UploadSingleRequest {
  private MultipartFile files; // Expect single file per request
}

