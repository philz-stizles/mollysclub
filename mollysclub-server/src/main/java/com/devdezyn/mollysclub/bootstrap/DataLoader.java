package com.devdezyn.mollysclub.bootstrap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
      seedPermissions();

      // Seed roles.
      seedRoles();

      // Seed users.
      seedUsers();


    }

    private void seedPermissions() {
      Map<String, List<String>> permissions = new HashMap<>();
      permissions.put("doctor", Arrays.asList("create", "read", "update", "delete", "write"));
      permissions.put("patient", Arrays.asList("create", "read", "update", "delete", "write"));

      if (permissionRepository.findAll().isEmpty()) {
        // Create permissions
        log.info("Creating permissions...");

        permissions.forEach((k, v) -> {
          v.forEach(p -> {
            permissionRepository
              .save(
                  Permission.builder()
                      .name(String.format("%s:%s.", k, p))
                        .description(String.format("User can execute %s actions on %s.", p, k))
                      .build()
              );
          });
        });

        log.info("Permissions have been created Successfully...");
      } else {
        log.info("Permissions have already been created Successfully...");
      }
    }

    private void seedRoles() {
      if (roleRepository.findAll().isEmpty()) {
        // Create roles
        log.info("Creating roles...");

        roleRepository.save(Role.builder().name("ADMIN").description("Global roles").build());
        roleRepository.save(Role.builder().name("DOCTOR").description("Global roles").build());
        roleRepository.save(Role.builder().name("PATIENT").description("Global roles").build());

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
