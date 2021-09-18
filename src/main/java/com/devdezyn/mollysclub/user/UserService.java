package com.devdezyn.mollysclub.user;

import java.util.List;

import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.role.RoleDto;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  UserDto getUserById(Long id);

  UserDto getUserByUsername(String email);

  UserDto getUserByEmail(String email);

  List<UserDto> getUsers();

  UserDto saveUser(UserDto user);

  RoleDto saveRole(RoleDto role);

  void addRoleToUser(String username, String roleName);

  UserDetails loadUserById(Long id);

  UserDetails loadUserByUsername(String username);

  UserDetails loadUserByEmail(String email);

  User createUser(RegisterRequest registerDto);

  int enableUser(String email);
}
