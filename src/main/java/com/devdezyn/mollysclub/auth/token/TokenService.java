package com.devdezyn.mollysclub.auth.token;

import java.time.LocalDateTime;
import java.util.Optional;

import com.devdezyn.mollysclub.user.User;


public interface TokenService {
  public void saveConfirmationToken(ConfirmationToken confirmationToken);
  
  public Optional<ConfirmationToken> getToken(String token);

  public Optional<ConfirmationToken> getTokenByAppUser(User appUser);

  public int setConfirmedAt(String token);
}
