package com.devdezyn.mollysclub.document_upload;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Getter
@Setter
public class FormRequest {
  private MultipartFile[] files; // Expect multiple files per request
}

