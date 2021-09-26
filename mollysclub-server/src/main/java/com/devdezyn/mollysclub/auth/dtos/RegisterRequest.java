package com.devdezyn.mollysclub.auth.dtos;

import javax.validation.constraints.*;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class RegisterRequest {
  @Size(min = 2, max = 40, message = "First name character length might not be meeting requirements, contact customer care to resolve this issue")
  private final String firstName;

  @Size(min = 2, max = 40, message = "Last name character length might not be meeting requirements, contact customer care to resolve this issue")
  private final String lastName;

  @NotBlank(message = "A valid username is required")
  @Size(min = 3, max = 15, message = "username must be between 3 to 15 characters long")
  private final String username;

  @NotBlank
  @Email(message = "email must be valid")
  private final String email;

  @Size(max = 15, message = "email must be valid")
  private final String phone;

  @NotBlank(message = "Password must not be blank")
  @Size(min = 6, max = 20, message = "Password must not be blank")
  private final String password;
}
