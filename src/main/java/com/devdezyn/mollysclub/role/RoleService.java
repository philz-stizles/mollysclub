package com.devdezyn.mollysclub.role;

import java.util.List;

public interface RoleService {
  RoleDto getRoleById(Long id);
  RoleDto getRoleByEmail(String email);
  List<RoleDto> getRoles();
  RoleDto saveRole(RoleDto role);
}
