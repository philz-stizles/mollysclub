package com.devdezyn.mollysclub.document_upload;

import lombok.*;

@Setter
@Getter
@Builder
public class UploadDto {
  private Long id;
  private String url;
  private String uploadId;
}

