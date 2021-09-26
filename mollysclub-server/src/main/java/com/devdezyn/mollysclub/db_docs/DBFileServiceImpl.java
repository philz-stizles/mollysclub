package com.devdezyn.mollysclub.db_docs;

import java.io.IOException;

import com.devdezyn.mollysclub.shared.exceptions.DocumentNotFoundException;
import com.devdezyn.mollysclub.shared.exceptions.FileStorageException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DBFileServiceImpl implements DBFileService {

  private final DBFileRepository dbFileRepository;

  @Override
  public DBFile storeFile(MultipartFile file) {
    // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = DBFile.builder()
              .fileName(fileName)
              .fileType(file.getContentType())
              .data(file.getBytes())
              .build();

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
  }

  @Override
  public DBFile getFile(String fileId) {
    return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new DocumentNotFoundException("File not found with id " + fileId));
  }


}
