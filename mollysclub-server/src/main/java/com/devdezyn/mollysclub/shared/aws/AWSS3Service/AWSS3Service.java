package com.devdezyn.mollysclub.shared.aws.AWSS3Service;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

  // String upload(String fileName, Optional<Map<String, String>> optionalMetaData, InputStream inputStream);

  String upload(MultipartFile file);

  byte[] download(String key);
}
