package com.devdezyn.mollysclub.shared.cloudinary;

import java.io.File;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

  String uploadBytes(byte[] bytes, Map<String, String> options);

  String uploadFile(File file, Map<String, String> options);

  String uploadBase64(String base64FileString, Map<String, String> options);
  
  String uploadVideo(MultipartFile file, Map<String, String> options);

  void transformImage();
}
