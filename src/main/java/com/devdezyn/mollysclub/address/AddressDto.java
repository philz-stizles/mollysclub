package com.devdezyn.mollysclub.address;

import lombok.*;

@Data
public class AddressDto {
  private Long id;
  private Long locationId;
  private String zip;
  private String street;
  private String city;
  private String state;
  private String country;
}
