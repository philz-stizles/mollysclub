package com.devdezyn.mollysclub.permission;

import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {

    public PermissionDto toDto(Permission entity) {
        if(entity == null) return null;

        PermissionDto dto = new PermissionDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    public Permission toEntity(PermissionDto dto) {
        if (dto == null)
            return null;
        
        Permission entity = new Permission();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        return entity;
    }
}