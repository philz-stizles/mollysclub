package com.devdezyn.mollysclub.bootstrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devdezyn.mollysclub.permission.Permission;
import com.devdezyn.mollysclub.permission.PermissionRepository;
import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.role.RoleRepository;
import com.devdezyn.mollysclub.user.User;
import com.devdezyn.mollysclub.user.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
  private final PermissionRepository permissionRepository;
  private final RoleRepository roleRepository;
  private final UserRepository userRepository;

  private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
      // Seed permissions.
      List<Permission> permissions = seedPermissions();

      // Seed roles.
      seedRoles(permissions);

      // Seed users.
      seedUsers();


    }

    private List<Permission> seedPermissions() {
      if (permissionRepository.findAll().isEmpty()) {
        Map<String, List<String>> permissions = new HashMap<>();
        permissions.put("doctor", Arrays.asList("create", "read", "update", "delete", "write"));
        permissions.put("patient", Arrays.asList("create", "read", "update", "delete", "write"));
        Collection<Permission> permissionsCollection = new ArrayList<>();
        // Create permissions
        log.info("Creating permissions...");

        permissions.forEach((k, v) -> {
          v.forEach(p -> {
            permissionsCollection.add(
                  Permission.builder()
                      .name(String.format("%s:%s.", k, p))
                      .description(String.format("User can execute %s actions on %s.", p, k))
                      .build()
              );
          });
        });

        List<Permission> createdPermissions = permissionRepository.saveAll(permissionsCollection);

        log.info("Permissions have been created Successfully...");
        return createdPermissions;
      } else {
        log.info("Permissions have already been created Successfully...");
        return permissionRepository.findAll();
      }
    }

    private void seedRoles(List<Permission> permissions) {
      if (roleRepository.findAll().isEmpty()) {
        // Create roles
        log.info("Creating roles...");

        var adminRole = Role.builder()
          .name("ADMIN")
          .description("Global roles")
          .isActive(true)
          .permissions(new HashSet<>(permissions))
          .build();

        var doctorRole = Role.builder()
          .name("DOCTOR")
          .description("Global roles")
            .isActive(true)
          .permissions(
            new HashSet<>(
                permissions
                  .stream()
                  .filter(p -> {
                    return p.getName().contains("doctor");
                        })
                  .collect(Collectors.toList())
            )
          )
          .build();
          
        var patientRole = Role.builder()
          .name("PATIENT")
          .description("Global roles")
            .isActive(true)
          .permissions(
            new HashSet<>(
                permissions
                  .stream()
                  .filter(p -> {
                    return p.getName().contains("patient");
                        })
                  .collect(Collectors.toList())
            )
          )
          .build();

        roleRepository.saveAll(Arrays.asList(adminRole, doctorRole, patientRole));
        log.info("Roles have been created Successfully...");
      } else {
        log.info("Roles have already been created Successfully...");
      }
    }

    private void seedUsers() {
      if (userRepository.findAll().isEmpty()) {
        // Create users
        log.info("Creating users...");
        Optional<Role> adminRole = roleRepository.findByName("ADMIN");

        if(adminRole.isPresent()) {
          userRepository.save(
            User.builder()
                .username("admin")
                .email("admin@mollysclub.com")
                .password(passwordEncoder.encode("password"))
                .locked(false)
                .enabled(true)
                .roles(
                  new HashSet<Role>(Arrays.asList(adminRole.get()))
                )
                .build()
        );

        log.info("Users have been created Successfully...");
        }
      } else {
        log.info("Users have already been created Successfully...");
      }
    }
}
