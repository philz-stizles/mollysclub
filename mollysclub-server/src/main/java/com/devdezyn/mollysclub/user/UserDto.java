package com.devdezyn.mollysclub.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
}