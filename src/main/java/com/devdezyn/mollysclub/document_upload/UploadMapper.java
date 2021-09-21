package com.devdezyn.mollysclub.document_upload;

import org.springframework.stereotype.Component;

@Component
public class UploadMapper {

    public UploadDto toDto(Upload entity) {
      UploadDto dto = UploadDto.builder()
        .id(entity.getId())
        .uploadId(entity.getUploadId())
        .url(entity.getUrl())
        .build();
        
        return dto;
    }

    public Upload toEntity(UploadDto dto) {
      Upload entity = new Upload();
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());
        entity.setUploadId(dto.getUploadId());

        return entity;
    }
}
