package com.devdezyn.mollysclub.auth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

import javax.validation.Valid;

import com.devdezyn.mollysclub.auth.dtos.LoginDto;
import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterResponse;
import com.devdezyn.mollysclub.auth.services.JwtTokenService;
import com.devdezyn.mollysclub.auth.services.RegistrationService;
import com.devdezyn.mollysclub.auth.token.JwtAuthenticationResponse;
import com.devdezyn.mollysclub.shared.ApiBodyResponse;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "Authentication")
@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
@Validated // class level
public class AuthController {
  private final RegistrationService registerService;
  private final JwtTokenService tokenService;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/register")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "Requested Resource Not Found"),
      @ApiResponse(code = 500, message = "Internal server error") })
  public ResponseEntity<ApiBodyResponse<RegisterResponse>> register(@Valid @RequestBody RegisterRequest registerRequest) {

    RegisterResponse registerResponse = registerService.createUser(registerRequest);

    URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/v1/auth/{username}")
                .buildAndExpand(registerResponse.getUsername()).toUri();

    return ResponseEntity
        .created(location)
        .body(new ApiBodyResponse<>(true, "User registered successfully"));
  }

  @PostMapping("/registerWithEmailConfirmation")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<ApiBodyResponse<RegisterResponse>> registerWithEmailConfirmation(RegisterRequest registerRequest) {

    var registerResponse = registerService.processConfirmationToken(registerRequest);

    return ResponseEntity.ok().body(new ApiBodyResponse<RegisterResponse>(true, "A verification link has been sent to your email", registerResponse));
  }

  @GetMapping("/confirmEmail")
  @ApiOperation(value = "This will confirm the users email", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public String confirmEmail(@RequestParam("token") String token) {
    return registerService.confirmToken(token);
  }

  @PostMapping("/login")
  @ApiOperation(value = "This will login an existing, valid user", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginRequest) {

        try {
          Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(), 
                loginRequest.getPassword()
            )
          );

          SecurityContextHolder
              .getContext()
              .setAuthentication(authentication);

          String token = tokenService.generateToken(authentication, "");
          return ResponseEntity.ok(new JwtAuthenticationResponse(token));

        } catch (Exception e) {
          log.error(e.getMessage(), e);
          return ResponseEntity.internalServerError().body(new ApiBodyResponse<>(false, "You cannot login at this time, please try again later"));
        }
  }

  @PostMapping("/refresh-token")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "Requested Resource Not Found"),
      @ApiResponse(code = 500, message = "Internal server error") })
  public String refreshToken(@RequestBody RegisterRequest registerRequest) {

    // return registrationService.register(registerRequest);

    return "";
  }
}
