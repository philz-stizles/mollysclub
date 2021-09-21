package com.devdezyn.mollysclub.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.models.UserPrincipal;
import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.role.RoleDto;
import com.devdezyn.mollysclub.role.RoleMapper;
import com.devdezyn.mollysclub.role.RoleRepository;
import com.devdezyn.mollysclub.shared.exceptions.BadRequestException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
  private final static String USER_NOT_FOUND_MSG = "user with %s %s not found";

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final UserMapper userMapper;
  private final RoleMapper roleMapper;
  private final BCryptPasswordEncoder passwordEncoder;

  @Override
  public UserDto getUserById(Long id) {
    Optional<User> existingUser = userRepository.findById(id);
    if(!existingUser.isPresent()) {
      throw new IllegalArgumentException("User does not exist");
    }
    return userMapper.toDto(existingUser.get());
  }

  @Override
  public UserDto getUserByEmail(String email) {
    Optional<User> existingUser = userRepository.findByEmail(email);
    if (!existingUser.isPresent()) {
      throw new IllegalArgumentException("User does not exist");
    }
    return userMapper.toDto(existingUser.get());
  }
  
  @Override
  public UserDto getUserByUsername(String username) {
    Optional<User> existingUser = userRepository.findByEmail(username);
    if(!existingUser.isPresent()) {
      throw new IllegalArgumentException("User does not exist");
    }
    return userMapper.toDto(existingUser.get());
  }

  @Override
  public List<UserDto> getUsers() {
    List<UserDto> userDtos = userRepository.findAll()
        .stream()
        .map(u -> userMapper.toDto(u))
        .collect(Collectors.toList());
    
    return userDtos;
  }

  @Override
  public UserDto saveUser(UserDto userDto) {
    log.info("Saving new user {} to the database", userDto.getUsername());
    var savedUser = userRepository.save(userMapper.toEntity(userDto));
    savedUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
    return userMapper.toDto(savedUser);
  }

  @Override
  public RoleDto saveRole(RoleDto roleDto) {
    log.info("Saving new role {} to the database", roleDto.getName());
    Role createdRole = roleRepository.save(roleMapper.toEntity(roleDto));
    return roleMapper.toDto(createdRole);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    log.info("Adding role {} to user {}", roleName, username);
    var existingUser = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
      
    Optional<Role> existingRole = roleRepository.findByName(roleName);
    if(!existingRole.isPresent()) {
      throw new IllegalArgumentException("User does not exist");
    }

    existingUser.getRoles().add(existingRole.get());
    
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
    log.debug(usernameOrEmail);
    User existingUser = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, "email or username", usernameOrEmail)));

    return UserPrincipal.create(existingUser);
  }
  
  @Override
  @Transactional
  public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
    User existingUser = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, "email or username", email)));

    return UserPrincipal.create(existingUser);
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    User existingUser = userRepository.findById(id)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, "id", id)));

    return UserPrincipal.create(existingUser);
  }
  
  public User createUser(RegisterRequest registerDto) {
    if (userRepository.existsByUsername(registerDto.getUsername())) {
      throw new BadRequestException("Username is already taken!");
    }

    if (userRepository.existsByEmail(registerDto.getEmail())) {
      throw new BadRequestException("Email Address already in use!");
    }

    // Creating user's account
    User user = new User(registerDto.getUsername(), registerDto.getEmail(), registerDto.getPassword());

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    // Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
    //   .orElseThrow(() -> new AppException("User Role not set."));

    // user.setRoles(Collections.singleton(userRole));
    return userRepository.save(user);

    // return new RegisterResponse(user.getUsername(), user.getEmail());
  }
  
  // public String createUser(UserDto userDto) {
  //   String token = "";
  //   boolean userExists = userRepository.findByEmail(appUser.getEmail()).isPresent();
  //   if (userExists) {
  //     ConfirmationToken confirmationToken = confirmationTokenService.getTokenByAppUser(appUser)
  //       .orElseThrow(() -> new IllegalStateException("token not found"));
  //     if (confirmationToken.getConfirmedAt() != null) {
  //       throw new IllegalStateException("Email already confirmed");
  //     } else {
  //       throw new IllegalStateException("Email has a pending confirmation. Check your email");
  //     }
  //   } else {
  //     // Encrypt user password
  //     String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
  //     appUser.setPassword(encodedPassword);

  //     // save new user to database
  //     appUserRepository.save(appUser);

  //     // save new user to database
  //     token = UUID.randomUUID().toString();
  //     ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
  //         LocalDateTime.now().plusMinutes(15), appUser);
  //     confirmationTokenService.saveConfirmationToken(confirmationToken);
  //   }

  //   return token;
  // }

  public int enableUser(String email) {
    return 1;
  }
}
