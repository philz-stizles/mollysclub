package com.devdezyn.mollysclub.pharmacy;

import org.springframework.stereotype.Component;

@Component
public class PharmacyMapper {

    public PharmacyDto toDto(Pharmacy entity) {
        if(entity == null) return null;

        PharmacyDto dto = new PharmacyDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public Pharmacy toEntity(PharmacyDto dto) {
        if (dto == null)
            return null;
        
        Pharmacy entity = new Pharmacy();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}