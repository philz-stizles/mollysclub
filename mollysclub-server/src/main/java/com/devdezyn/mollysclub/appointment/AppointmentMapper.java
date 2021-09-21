package com.devdezyn.mollysclub.appointment;

import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDto toDto(Appointment entity) {
        if(entity == null) return null;

        AppointmentDto dto = new AppointmentDto();
        dto.setId(entity.getId());
        dto.setWhen(entity.getWhen());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public Appointment toEntity(AppointmentDto dto) {
        if (dto == null)
            return null;
        
        Appointment entity = new Appointment();
        entity.setId(dto.getId());
        entity.setWhen(dto.getWhen());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }
}