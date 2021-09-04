package com.devdezyn.mollysclub.address;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class AddressDTO {
  private Long id;
  
  private String street;
  private String city;
  private String country;
}
