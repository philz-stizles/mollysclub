package com.devdezyn.mollysclub.user;

import java.util.Set;

import com.devdezyn.mollysclub.role.RoleDto;

import lombok.*;

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
  private String password;
  private Set<RoleDto> roles;
  private Boolean locked;
  private Boolean enabled;
  private Boolean credentialExpired;
  private Boolean accountExpired;
}