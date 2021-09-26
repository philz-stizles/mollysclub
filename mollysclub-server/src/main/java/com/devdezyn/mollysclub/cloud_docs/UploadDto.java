package com.devdezyn.mollysclub.cloud_docs;

import lombok.*;

@Setter
@Getter
@Builder
public class UploadDto {
  private Long id;
  private String url;
  private String uploadId;
}

