package com.devdezyn.mollysclub.auth.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponse {
  private String username;

  private String email;
}
