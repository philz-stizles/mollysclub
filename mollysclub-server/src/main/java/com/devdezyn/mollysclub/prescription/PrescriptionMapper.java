package com.devdezyn.mollysclub.prescription;

import org.springframework.stereotype.Component;

@Component
public class PrescriptionMapper {

    public PrescriptionDto toDto(Prescription entity) {
        if(entity == null) return null;

        PrescriptionDto dto = new PrescriptionDto();
        dto.setId(entity.getId());

        return dto;
    }

    public Prescription toEntity(PrescriptionDto dto) {
        if (dto == null)
            return null;
        
        Prescription entity = new Prescription();
        entity.setId(dto.getId());

        return entity;
    }
}