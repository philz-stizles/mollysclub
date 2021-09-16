package com.devdezyn.mollysclub.role;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {
  private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

  private final RoleRepository roleRepository;

  @Override
  public RoleDto getRoleById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RoleDto getRoleByEmail(String email) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<RoleDto> getRoles() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RoleDto saveRole(RoleDto role) {
    // TODO Auto-generated method stub
    return null;
  }
}
