package com.devdezyn.mollysclub.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoggedInToken {
  private String accessToken;
  private String refreshToken;
}