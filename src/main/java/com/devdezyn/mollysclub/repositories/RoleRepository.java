package com.devdezyn.mollysclub.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdezyn.mollysclub.domain.Role;
import com.devdezyn.mollysclub.domain.PermissionName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(PermissionName roleName);
}
