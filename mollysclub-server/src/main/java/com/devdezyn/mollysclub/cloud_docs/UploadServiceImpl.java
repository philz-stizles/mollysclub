package com.devdezyn.mollysclub.cloud_docs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import com.devdezyn.mollysclub.shared.aws.AWSSESConfig;
import com.devdezyn.mollysclub.shared.aws.AWSS3Service.AWSS3Service;
import com.devdezyn.mollysclub.shared.cloudinary.CloudinaryService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {

  private final CloudinaryService cloudinaryService;

  private final AWSS3Service awsS3Service;

  //Save the uploaded file to this folder
  // private static String UPLOADED_FOLDER = "F://temp//";

  private final Path UPLOADED_FOLDER = Paths.get("uploads");

  public void init() {
    try {
      if (!Files.exists(UPLOADED_FOLDER)) {

        Files.createDirectory(UPLOADED_FOLDER);
        System.out.println("Directory created");
      } else {

        System.out.println("Directory already exists");
      }
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  public String saveUploadFileToCloudinary(MultipartFile file) {
    try {
      File uploadedFile = convertMultiPartToFile(file);
      String url = cloudinaryService.uploadFile(uploadedFile, null);

      boolean isDeleted = uploadedFile.delete();

        if (isDeleted) {
          System.out.println("File successfully deleted");
        } else {
          System.out.println("File doesn't exist");
        }

        return url;

    } catch (IOException e) {
      throw new RuntimeException("");
    }
  }

  public String saveUploadBytesToCloudinary(MultipartFile file) {
    try {
      return cloudinaryService.uploadBytes(file.getBytes(), null);
    } catch (IOException e) {
      throw new RuntimeException("");
    }
  }

  public void saveMultipleToCloudinary(List<MultipartFile> files) {

    for (MultipartFile file : files) {
      try {
        cloudinaryService.uploadBytes(file.getBytes(), null);
      } catch (IOException e) {
        log.error(e.getMessage());
        continue;
      }
    }

    log.error("Files have been uploaded successfully");

  }

  public String saveSingleToAWS(MultipartFile file) {

    return awsS3Service.upload(file);
  }

  public void saveMultipleToAWS(List<MultipartFile> files) {

    for (MultipartFile file : files) {

    }

  }

  @Override
  public byte[] downloadFileFromAWS(String fileName) {
    return awsS3Service.download(fileName);
  }

  public void saveToDB(List<MultipartFile> files) {

    for (MultipartFile file : files) {
    }

  }

  public void saveToDisk(List<MultipartFile> files) {

    for (MultipartFile file : files) {
      if (file.isEmpty()) {
        continue; //next pls
      }

      try {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
      } catch (Exception e) {
        //TODO: handle exception
      }
    }

  }

  @Override
  public void removeFromCloudinary(List<MultipartFile> files) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeFromDB(List<MultipartFile> files) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeFromDisk(List<MultipartFile> files) {
    // TODO Auto-generated method stub

  }

  @Override
  public Resource loadAsResource(String filename) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveToDisk(MultipartFile file) {
    try {
      Files.copy(file.getInputStream(), UPLOADED_FOLDER.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = UPLOADED_FOLDER.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void removeAllFromDisk() {
    FileSystemUtils.deleteRecursively(UPLOADED_FOLDER.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(UPLOADED_FOLDER, 1).filter(path -> !path.equals(UPLOADED_FOLDER))
          .map(UPLOADED_FOLDER::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

  @Override
  public void removeFromAWS(MultipartFile file) {
    // TODO Auto-generated method stub

  }

  // private boolean validateFile(MultipartFile file) {
  //   //check if the file is empty
  //   if (file.isEmpty()) {
  //     throw new IllegalStateException("Cannot upload empty file");
  //   }

  //   //Check if the file is an image
  //   if (!Arrays.asList(IMAGE_PNG.getMimeType(),
  //           IMAGE_BMP.getMimeType(),
  //           IMAGE_GIF.getMimeType(),
  //           IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
  //       throw new IllegalStateException("FIle uploaded is not an image");
  //   }
  // }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
      File fileFromMultipart = new File(file.getOriginalFilename());

      FileOutputStream fos = new FileOutputStream(fileFromMultipart);
      fos.write(file.getBytes());
      fos.close();

      return fileFromMultipart;
    }}
