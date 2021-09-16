package com.devdezyn.mollysclub.doctor;

import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public DoctorDto toDto(Doctor entity) {
        DoctorDto dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setSpecialization(entity.getSpecialization());
        dto.setMobile(entity.getMobile());
        dto.setGender(entity.getGender());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());

        return dto;
    }

    public Doctor toEntity(DoctorDto dto) {
        Doctor entity = new Doctor();
        entity.setId(dto.getId());
        entity.setSpecialization(dto.getSpecialization());
        entity.setMobile(dto.getMobile());
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());

        return entity;
    }
}
