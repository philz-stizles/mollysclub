package com.devdezyn.mollysclub.auth.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.devdezyn.mollysclub.auth.models.ConfirmationToken;
import com.devdezyn.mollysclub.auth.token.ConfirmationTokenRepository;
import com.devdezyn.mollysclub.user.User;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
  private final ConfirmationTokenRepository confirmationTokenRepository;

  public String saveConfirmationToken(User user) {
    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
        LocalDateTime.now().plusMinutes(15), user);
    confirmationTokenRepository.save(confirmationToken);

    return token;
  }

  public Optional<ConfirmationToken> getToken(String token) {
    return confirmationTokenRepository.findByToken(token);
  }

   public Optional<ConfirmationToken> getTokenByUser(User appUser) {
    return confirmationTokenRepository.findByUser(appUser);
  }

  public int setConfirmedAt(String token) {
    return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
  }
}
