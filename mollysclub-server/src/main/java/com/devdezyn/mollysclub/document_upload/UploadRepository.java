package com.devdezyn.mollysclub.document_upload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
  
}
