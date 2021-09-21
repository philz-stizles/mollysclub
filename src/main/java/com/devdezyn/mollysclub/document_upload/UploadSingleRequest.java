package com.devdezyn.mollysclub.document_upload;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Getter
@Setter
public class UploadSingleRequest {
  private MultipartFile files; // Expect single file per request
}

