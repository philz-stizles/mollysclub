package com.devdezyn.mollysclub.user;

import java.util.List;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.models.UserPrincipal;
import com.devdezyn.mollysclub.role.RoleDto;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  UserDto getUserById(Long id);

  UserDto getUserByUsername(String email);

  UserDto getUserByEmail(String email);

  List<UserDto> getUsers();

  // Addresses
  AddressDto createAddress(UserPrincipal currentUserPrincipal, AddressDto addressDto);
  List<AddressDto> getAddresses(UserPrincipal currentUserPrincipal);
  AddressDto updateAddress(UserPrincipal currentUserPrincipal, Long id, AddressDto addressDto);
  void deleteAddress(UserPrincipal currentUserPrincipal, Long id);

  User saveUser(RegisterRequest registerRequest);

  RoleDto saveRole(RoleDto role);

  void addRoleToUser(String username, String roleName);

  UserDetails loadUserById(Long id);

  UserDetails loadUserByUsername(String username);

  UserDetails loadUserByEmail(String email);

  User createUser(RegisterRequest registerDto);

  UserDto enableUser(Long id);
}
