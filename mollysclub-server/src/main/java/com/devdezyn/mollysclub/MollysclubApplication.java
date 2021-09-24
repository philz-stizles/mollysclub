package com.devdezyn.mollysclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MollysclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MollysclubApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(
	// 		PermissionRepository permissionRepository, 
	// 		RoleRepository roleRepository, 
	// 	  UserRepository userRepository ) {
  //       return args -> {
  //           Permission read = new Permission("read", "User can create");
  //           Permission write = new Permission("write", "User can create, update, delete");
  //           Permission create = new Permission("create", "User can create");
	// 				  Permission update = new Permission("update", "User can update");
	// 					Permission delete = new Permission("delete", "User can delete");

  //           permissionRepository.saveAll(List.of(read, create, write, update, delete));
  //       };
  //   }

}
