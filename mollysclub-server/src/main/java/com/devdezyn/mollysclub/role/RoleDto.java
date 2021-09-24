package com.devdezyn.mollysclub.role;

import java.util.Set;

import com.devdezyn.mollysclub.permission.PermissionDto;

import lombok.Data;

@Data
public class RoleDto {
  private Long id;
  private String name;
  private String description;
  private Set<PermissionDto> permissions;
}
