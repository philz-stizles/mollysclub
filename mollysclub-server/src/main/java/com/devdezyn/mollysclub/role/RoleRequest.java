package com.devdezyn.mollysclub.role;

import java.util.Set;

import lombok.Data;

@Data
public class RoleRequest {
  private Long id;
  private String name;
  private String description;
  private Set<Long> permissions;
}
