package com.devdezyn.mollysclub.auth.services;

import java.time.LocalDateTime;

import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterResponse;

public interface RegistrationService {

  public RegisterResponse processConfirmationToken(RegisterRequest request);
  
  public RegisterResponse createUser(RegisterRequest request);

  public String confirmToken(String token);
}
