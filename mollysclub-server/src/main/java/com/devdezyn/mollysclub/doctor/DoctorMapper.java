package com.devdezyn.mollysclub.doctor;

import com.devdezyn.mollysclub.user.UserMapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DoctorMapper {

    private final UserMapper userMapper;

    public DoctorDto toDto(Doctor entity) {
        DoctorDto dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setSpecialization(entity.getSpecialization());
        dto.setMobile(entity.getMobile());
        dto.setGender(entity.getGender());
        dto.setAge(entity.getAge());
        dto.setUser(userMapper.toDto(entity.getUser()));

        return dto;
    }

    public Doctor toEntity(DoctorDto dto) {
        Doctor entity = new Doctor();
        entity.setId(dto.getId());
        entity.setSpecialization(dto.getSpecialization());
        entity.setMobile(dto.getMobile());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        entity.setUser(userMapper.toEntity(dto.getUser()));

        return entity;
    }
}
