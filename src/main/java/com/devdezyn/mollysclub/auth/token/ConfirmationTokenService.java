package com.devdezyn.mollysclub.auth.token;

import java.time.LocalDateTime;
import java.util.Optional;

import com.devdezyn.mollysclub.user.User;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
  private final ConfirmationTokenRepository confirmationTokenRepository;

  public void saveConfirmationToken(ConfirmationToken confirmationToken) {
    confirmationTokenRepository.save(confirmationToken);
  }

  public Optional<ConfirmationToken> getToken(String token) {
    return confirmationTokenRepository.findByToken(token);
  }

   public Optional<ConfirmationToken> getTokenByAppUser(User appUser) {
    return confirmationTokenRepository.findByAppUser(appUser);
  }

  public int setConfirmedAt(String token) {
    return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
  }
}
