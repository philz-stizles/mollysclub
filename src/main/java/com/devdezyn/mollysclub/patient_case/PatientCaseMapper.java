package com.devdezyn.mollysclub.patient_case;

import org.springframework.stereotype.Component;

@Component
public class PatientCaseMapper {

    public PatientCaseDto toDto(PatientCase entity) {
        if(entity == null) return null;

        PatientCaseDto dto = new PatientCaseDto();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public PatientCase toEntity(PatientCaseDto dto) {
        if (dto == null)
            return null;
        
        PatientCase entity = new PatientCase();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }
}