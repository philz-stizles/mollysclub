package com.devdezyn.mollysclub.cloud_docs;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
  // AWS

  void saveMultipleToAWS(List<MultipartFile> files);

  String saveSingleToAWS(MultipartFile file);

  void removeFromAWS(MultipartFile file);

  byte[] downloadFileFromAWS(String fileName);

  // Cloudinary

  void saveMultipleToCloudinary(List<MultipartFile> files);

  String saveUploadFileToCloudinary(MultipartFile file);

  String saveUploadBytesToCloudinary(MultipartFile file);

  void removeFromCloudinary(List<MultipartFile> files);

  // DB

  void saveToDB(List<MultipartFile> files);

  void removeFromDB(List<MultipartFile> files);

  // Disk file

  void saveToDisk(List<MultipartFile> files);

  void saveToDisk(MultipartFile file);

  void removeFromDisk(List<MultipartFile> files);

  void removeAllFromDisk();

  // Loading files

  Stream<Path> loadAll();

  // Path load(String filename);
  
  Resource load(String filename);

	Resource loadAsResource(String filename);
}
