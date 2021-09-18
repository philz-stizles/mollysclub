package com.devdezyn.mollysclub.auth.dtos;

import javax.validation.constraints.*;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RegisterRequest {
  @Size(min = 2, max = 40)
  private final String firstName;

  @Size(min = 2, max = 40)
  private final String lastName;

  @NotBlank
  @Size(min = 3, max = 15)
  private final String username;

  @NotBlank
  @Email
  private final String email;

  @NotBlank
  @Size(min = 6, max = 20)
  private final String password;
}
