package com.devdezyn.mollysclub.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {
  private Long id;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long locationId;
  
  private String zip;
  private String street;
  private String city;
  private String state;
  private String country;
}
