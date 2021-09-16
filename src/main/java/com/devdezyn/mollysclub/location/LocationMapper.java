package com.devdezyn.mollysclub.location;

import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDto toDto(Location entity) {
        if(entity == null) return null;

        LocationDto dto = new LocationDto();
        dto.setId(entity.getId());
        dto.setLongitude(entity.getLongitude());
        dto.setLatitude(entity.getLatitude());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public Location toEntity(LocationDto dto) {
        if (dto == null)
            return null;
        
        Location entity = new Location();
        entity.setId(dto.getId());
        entity.setLongitude(dto.getLongitude());
        entity.setLatitude(dto.getLatitude());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }
}