package com.devdezyn.mollysclub.db_docs;

import java.util.UUID;

import javax.persistence.*;

import com.devdezyn.mollysclub.shared.models.DateAudit;

import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "uploads")
public class DBFile extends DateAudit {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private UUID id;

  @Lob
  private byte[] data;

  private String fileName;

  private String fileType;
}

