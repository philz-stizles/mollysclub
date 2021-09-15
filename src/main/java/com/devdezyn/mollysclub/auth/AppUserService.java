package com.devdezyn.mollysclub.auth;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devdezyn.mollysclub.auth.token.ConfirmationToken;
import com.devdezyn.mollysclub.auth.token.ConfirmationTokenService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
  private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

  private final AppUserRepository appUserRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final ConfirmationTokenService confirmationTokenService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return appUserRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
      return appUserRepository.findById(id).orElseThrow(
          () -> new UsernameNotFoundException("User not found with id : " + id)
      );
  }
  
  public String registerUser(AppUser appUser) {
    String token = "";
    boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
    if (userExists) {
      ConfirmationToken confirmationToken = confirmationTokenService.getTokenByAppUser(appUser)
        .orElseThrow(() -> new IllegalStateException("token not found"));
      if (confirmationToken.getConfirmedAt() != null) {
        throw new IllegalStateException("Email already confirmed");
      } else {
        throw new IllegalStateException("Email has a pending confirmation. Check your email");
      }
    } else {
      // Encrypt user password
      String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
      appUser.setPassword(encodedPassword);

      // save new user to database
      appUserRepository.save(appUser);

      // save new user to database
      token = UUID.randomUUID().toString();
      ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
          LocalDateTime.now().plusMinutes(15), appUser);
      confirmationTokenService.saveConfirmationToken(confirmationToken);
    }

    return token;
  }

  public int enableAppUser(String email) {
    return appUserRepository.enableAppUser(email);
  }
  
  // public String register(AppUser appUser) {
  //   boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
  //   if (userExists) {
  //     throw new IllegalStateException("Email already taken");
  //   }
    
  //   // Encrypt user password
  //   String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
  //   appUser.setPassword(encodedPassword);

  //   // save new user to database
  //   appUserRepository.save(appUser);

  //   // Send email confirmation

  //   return "";
  // }
}
