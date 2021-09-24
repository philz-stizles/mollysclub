package com.devdezyn.mollysclub.attendee;

import org.springframework.stereotype.Component;

@Component
public class AttendeeMapper {

    public AttendeeDto toDto(Attendee entity) {
        if(entity == null) return null;

        AttendeeDto dto = new AttendeeDto();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());

        return dto;
    }

    public Attendee toEntity(AttendeeDto dto) {
        if (dto == null)
            return null;
        
        Attendee entity = new Attendee();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());

        return entity;
    }
}