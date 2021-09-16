package com.devdezyn.mollysclub.address;

import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto toDto(Address entity) {
        if(entity == null) return null;

        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setZip(entity.getZip());
        dto.setStreet(entity.getStreet());
        dto.setState(entity.getState());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());

        return dto;
    }

    public Address toEntity(AddressDto dto) {
        if (dto == null)
            return null;
        
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setZip(dto.getZip());
        entity.setStreet(dto.getStreet());
        entity.setState(dto.getState());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());

        return entity;
    }
}