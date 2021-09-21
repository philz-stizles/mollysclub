package com.devdezyn.mollysclub.address;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressMapperTest {

    @Test
    public void testToEntity() {
        AddressDto dto = new AddressDto();
        dto.setId(1L);
        dto.setZip("101112");
        dto.setStreet("Oyadiran");
        dto.setCity("Yaba");
        dto.setState("Lagos");
        dto.setCountry("Nigeria");

        AddressMapper mapper = new AddressMapper();
        Address entity = mapper.toEntity(dto);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getZip(), dto.getZip());
        assertEquals(entity.getStreet(), dto.getStreet());
        assertEquals(entity.getState(), dto.getState());
        assertEquals(entity.getCity(), dto.getCity());
        assertEquals(entity.getCountry(), dto.getCountry());
    }

    @Test
    public void testToDto() {
        Address entity = new Address();
        entity.setId(1L);
        entity.setZip("101112");
        entity.setStreet("Oyadiran");
        entity.setCity("Yaba");
        entity.setState("Lagos");
        entity.setCountry("Nigeria");

        AddressMapper mapper = new AddressMapper();
        AddressDto dto = mapper.toDto(entity);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getZip(), entity.getZip());
        assertEquals(dto.getStreet(), entity.getStreet());
        assertEquals(dto.getState(), entity.getState());
        assertEquals(dto.getCity(), entity.getCity());
        assertEquals(dto.getCountry(), entity.getCountry());
    }
}
