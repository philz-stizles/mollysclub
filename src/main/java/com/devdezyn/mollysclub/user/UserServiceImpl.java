package com.devdezyn.mollysclub.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devdezyn.mollysclub.auth.token.ConfirmationTokenService;
import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.role.RoleDto;
import com.devdezyn.mollysclub.role.RoleMapper;
import com.devdezyn.mollysclub.role.RoleRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
  private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final UserMapper userMapper;
  private final RoleMapper roleMapper;
  private final PasswordEncoder passwordEncoder;
  private final ConfirmationTokenService confirmationTokenService;

  

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
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
  }
  
  // @Override
  // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
  //   return appUserRepository.findByEmail(email)
  //       .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
  // }

  public UserDetails loadUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, id)));
    
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
  }
  
  // public String registerUser(User appUser) {
  //   String token = "";
  //   boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
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

  // public int enableAppUser(String email) {
  //   return appUserRepository.enableAppUser(email);
  // }
}
