package com.devdezyn.mollysclub.document_upload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.devdezyn.mollysclub.shared.models.BaseEntity;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "uploads")
public class Upload extends BaseEntity {
  private String url;

  @Column(name = "upload_id")
  private String uploadId;

  public Upload() {
    super();
  }

  public Upload(Long id, String url, String uploadId) {
    super(id);
    this.url = url;
    this.uploadId = uploadId;
  }
}

