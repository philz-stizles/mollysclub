package com.devdezyn.mollysclub.bootstrap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devdezyn.mollysclub.domain.Permission;
import com.devdezyn.mollysclub.domain.PermissionName;
import com.devdezyn.mollysclub.repositories.PermissionRepository;

@Component
public class DataLoader implements CommandLineRunner {
    private final PermissionRepository permissionRepository;

    public DataLoader(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      if(permissionRepository.findAll().isEmpty()) {
        // Create permissions
        System.out.println("Creating permissions...");
          
        permissionRepository.save(new Permission(PermissionName.PATIENT_CREATE.toString()));
        permissionRepository.save(new Permission(PermissionName.PATIENT_READ.toString()));
        permissionRepository.save(new Permission(PermissionName.PATIENT_WRITE.toString()));

        System.out.println("Permissions have been created Successfully...");
      } else {
        System.out.println("Permissions have already been created Successfully...");
      }
    }
}
