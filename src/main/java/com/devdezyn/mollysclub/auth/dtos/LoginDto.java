package com.devdezyn.mollysclub.auth.dtos;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class LoginDto {
    
    @JsonProperty("email")
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
  @Size(min = 6, max = 20)
    private String password;
}
