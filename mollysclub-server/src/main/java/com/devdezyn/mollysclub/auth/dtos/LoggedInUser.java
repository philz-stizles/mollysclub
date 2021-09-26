package com.devdezyn.mollysclub.auth.dtos;

import java.util.Set;

import lombok.*;

@Data
@Builder
public class LoggedInUser {
  private Long id;
  private String username;
  private String email;
  private Set<LoggedInRole> roles;
  private LoggedInToken tokens;
}


