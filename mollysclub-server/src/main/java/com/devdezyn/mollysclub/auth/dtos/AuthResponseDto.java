package com.devdezyn.mollysclub.auth.dtos;

import lombok.*;

@AllArgsConstructor
@Builder
public class AuthResponseDto {
    private Boolean status;
    private String message;
    private LoggedInUser data;
}
