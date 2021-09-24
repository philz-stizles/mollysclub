package com.devdezyn.mollysclub.user;

import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User entity) {
        if(entity == null) return null;

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    public User toEntity(UserDto dto) {
        if (dto == null)
            return null;

        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());

        return entity;
    }
    
    public User fromRequestToEntity(RegisterRequest request) {
        if (request == null)
            return null;

        return User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .password(request.getPassword())
                .build();
    }
}