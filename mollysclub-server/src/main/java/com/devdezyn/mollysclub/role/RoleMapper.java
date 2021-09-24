package com.devdezyn.mollysclub.role;

import java.util.stream.Collectors;

import com.devdezyn.mollysclub.permission.PermissionMapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private final PermissionMapper permissionMapper;

    public RoleDto toDto(Role entity) {
        if(entity == null) return null;

        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPermissions(
                entity.getPermissions()
                    .stream()
                        .map(p -> permissionMapper.toDto(p))
                    .collect(Collectors.toSet())
        );

        return dto;
    }

    public Role toEntity(RoleDto dto) {
        if (dto == null)
            return null;
        
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPermissions(
                dto.getPermissions()
                    .stream()
                        .map(p -> permissionMapper.toEntity(p))
                    .collect(Collectors.toSet())
        );

        return entity;
    }
}