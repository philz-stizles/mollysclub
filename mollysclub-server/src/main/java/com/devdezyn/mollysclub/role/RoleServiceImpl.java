package com.devdezyn.mollysclub.role;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import com.devdezyn.mollysclub.permission.Permission;
import com.devdezyn.mollysclub.permission.PermissionDto;
import com.devdezyn.mollysclub.permission.PermissionService;
import com.devdezyn.mollysclub.shared.exceptions.NotFoundException;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
// @Transactional
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;
  private final PermissionService permissionService;
  private final RoleMapper roleMapper;

  @Override
  public RoleDto getById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RoleDto getByName(String name) {
    // TODO Auto-generated method stub
    return null;
  }

   @Override
  public RoleDto searchByDescription(String description) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<RoleDto> getRoles() {
    return roleRepository.findAll()
        .stream()
        .map(r -> roleMapper.toDto(r))
        .collect(Collectors.toList());
  }

@Transactional
  @Override
  public RoleDto createRole(RoleRequest roleRequest) {

    List<Permission> permissions = permissionService.getPermissionsByIds(roleRequest.getPermissions());

    Role newRole = Role.builder().name(roleRequest.getName()).description(roleRequest.getDescription())
        .permissions(Set.copyOf(permissions))
        // .permissions(new HashSet<>(permissions))
        .build();
    var createdRole = roleRepository.save(newRole);

    return roleMapper.toDto(createdRole);
  }

  @Transactional
  @Override
  public RoleDto updateRole(Long id, RoleRequest roleRequest) {
    try {
      List<Permission> permissions = permissionService.getPermissionsByIds(roleRequest.getPermissions());

      Optional<Role> existingRole = roleRepository.findById(id);

      if (existingRole.isPresent()) {
        Role targetRole = existingRole.get();

        var oldPermissions = targetRole.getPermissions();

        Set<Permission> newPermissions = oldPermissions.stream()
        .distinct()
        .filter(permissions::contains)
        .collect(Collectors.toSet());

        targetRole.setName(roleRequest.getName());
        targetRole.setDescription(roleRequest.getDescription());
        targetRole.getPermissions().addAll(newPermissions);
        // targetRole.getPermissions().clear();
        // targetRole.getPermissions().addAll(Set.copyOf(permissions));

        var savedRole = roleRepository.save(targetRole);
        
        return roleMapper.toDto(savedRole);
      } else {
        throw new RuntimeException("Role does not exist");
      }
    } catch (Exception e) {
      log.error(e.getMessage());
      throw e;
    }
  }

  @Override
  public RoleDto archiveRole(Long id) {
    Optional<Role> existingRole = roleRepository.findById(id);

    if (existingRole.isPresent()) {
      Role targetRole = existingRole.get();
      targetRole.setIsActive(false);

      roleRepository.save(targetRole);
      
      return roleMapper.toDto(targetRole);
    } else {
      throw new RuntimeException("Role does not exist");
    }
  }
}
