package com.devdezyn.mollysclub.gymn;

import org.springframework.stereotype.Component;

@Component
public class GymnMapper {

    public GymnDto toDto(Gymn entity) {
        if(entity == null) return null;

        GymnDto dto = new GymnDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLogo(entity.getLogo());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public Gymn toEntity(GymnDto dto) {
        if (dto == null)
            return null;
        
        Gymn entity = new Gymn();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLogo(dto.getLogo());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }
}