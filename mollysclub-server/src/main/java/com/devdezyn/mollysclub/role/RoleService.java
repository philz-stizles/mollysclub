package com.devdezyn.mollysclub.role;

import java.util.List;

public interface RoleService {
  RoleDto createRole(RoleRequest roleRequest);

  RoleDto getById(Long id);

  // RoleDto getRolesByNames(List<String> names);

  RoleDto getByName(String email);
  RoleDto searchByDescription(String email);

  List<RoleDto> getRoles();
  
  RoleDto updateRole(Long id, RoleRequest roleRequest);

  RoleDto archiveRole(Long id);
}
