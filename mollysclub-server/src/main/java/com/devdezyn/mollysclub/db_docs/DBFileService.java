package com.devdezyn.mollysclub.db_docs;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DBFileService {
  DBFile storeFile(MultipartFile file);

  DBFile getFile(String fileId);
}
