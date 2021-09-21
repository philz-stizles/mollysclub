package com.devdezyn.mollysclub.user;

import java.util.Collection;
import java.util.ArrayList;

import lombok.Data;

import com.devdezyn.mollysclub.role.Role;

@Data
public class UserDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String password;
  private Collection<Role> roles = new ArrayList<>();
  private Boolean locked;
  private Boolean enabled;
  private Boolean credentialExpired;
  private Boolean accountExpired;
}