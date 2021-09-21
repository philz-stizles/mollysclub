package com.devdezyn.mollysclub.gymn;

import java.util.Date;
import java.util.List;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.user.UserDto;

import lombok.Data;

@Data
public class GymnDto {
  private Long id;
  private String name;
  private String logo;
  private Date createdAt;
  private Date updatedAt;
  private List<AddressDto> addresses;
  private UserDto account;
}
