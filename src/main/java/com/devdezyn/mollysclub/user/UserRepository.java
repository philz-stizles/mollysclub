package com.devdezyn.mollysclub.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findById(Long id);

  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);

  Optional<User> findByUsernameOrEmail(String username, String email);

  List<User> findByIdIn(List<Long> userIds);
  
  Boolean existsByEmail(String email);

  Boolean existsByUsername(String username);

  boolean existsById(Long id);

  // int enableUser(String email);
}
