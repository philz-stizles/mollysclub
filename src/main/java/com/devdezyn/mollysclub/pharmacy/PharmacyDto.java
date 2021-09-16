package com.devdezyn.mollysclub.pharmacy;

import java.util.List;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.location.LocationDto;
import com.devdezyn.mollysclub.user.UserDto;

import lombok.Data;

@Data
public class PharmacyDto {
    private Long id;
    private String name;
    private String logo;
    private String bio;
    private List<AddressDto> addresses;
    private List<LocationDto> locations;
    private UserDto account;
}
