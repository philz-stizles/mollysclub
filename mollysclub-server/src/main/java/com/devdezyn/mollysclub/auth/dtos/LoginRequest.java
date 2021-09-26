package com.devdezyn.mollysclub.auth.dtos;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class LoginRequest {
    
  @JsonProperty("email")
  @NotBlank(message = "Username or email must not be blank")
  private String usernameOrEmail;

  @NotBlank(message = "Password must not be blank")
  @Size(min = 6, max = 20, message = "Password length must be greater than 6 but less than 20 characters")
  private String password;
}
