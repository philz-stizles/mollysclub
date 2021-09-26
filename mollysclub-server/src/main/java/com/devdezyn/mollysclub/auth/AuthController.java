package com.devdezyn.mollysclub.auth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.devdezyn.mollysclub.auth.dtos.LoggedInRole;
import com.devdezyn.mollysclub.auth.dtos.LoggedInToken;
import com.devdezyn.mollysclub.auth.dtos.LoggedInUser;
import com.devdezyn.mollysclub.auth.dtos.LoginRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterResponse;
import com.devdezyn.mollysclub.auth.models.UserPrincipal;
import com.devdezyn.mollysclub.auth.services.JwtTokenService;
import com.devdezyn.mollysclub.auth.services.RegistrationService;
import com.devdezyn.mollysclub.auth.token.JwtAuthenticationResponse;
import com.devdezyn.mollysclub.shared.ApiResponseBody;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
  public ResponseEntity<ApiResponseBody<RegisterResponse>> register(
      @Valid @RequestBody RegisterRequest registerRequest) {

    RegisterResponse registerResponse = registerService.createUser(registerRequest);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/auth/{username}")
        .buildAndExpand(registerResponse.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponseBody<>(true, "User registered successfully"));
  }
  
  @PostMapping("/doctor/register")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "Requested Resource Not Found"),
      @ApiResponse(code = 500, message = "Internal server error") })
  public ResponseEntity<ApiResponseBody<RegisterResponse>> registerDoctor(
      @Valid @RequestBody RegisterRequest registerRequest) {

    RegisterResponse registerResponse = registerService.createDoctor(registerRequest);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/auth/{username}")
        .buildAndExpand(registerResponse.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponseBody<>(true, "User registered successfully"));
  }

    @PostMapping("/doctor/register-with-email-confirmation")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "Requested Resource Not Found"),
      @ApiResponse(code = 500, message = "Internal server error") })
  public ResponseEntity<ApiResponseBody<RegisterResponse>> confirmDoctorsEmail (
      @Valid @RequestBody RegisterRequest registerRequest) {

    log.info(registerRequest.getEmail());

    RegisterResponse registerResponse = registerService.processDoctorsEmailConfirmation(registerRequest);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/auth/{username}")
        .buildAndExpand(registerResponse.getUsername()).toUri();

    return ResponseEntity.created(location)
        .body(new ApiResponseBody<>(true, "A verification link has been sent to " + registerResponse.getEmail()));
  }
  
  @GetMapping("/confirm-email-create-doctor")
  @ApiOperation(value = "This will confirm the users email", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<ApiResponseBody<RegisterResponse>> createDoctor(@RequestParam("token") String token) {
    RegisterResponse registerResponse = registerService.createDoctor(token);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/doctors/{username}")
        .buildAndExpand(registerResponse.getUsername()).toUri();
    
    return ResponseEntity.created(location)
        .body(new ApiResponseBody<>(true, "Doctor created successfully"));  
  }
  
  @PostMapping("/patient/register")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "Requested Resource Not Found"),
      @ApiResponse(code = 500, message = "Internal server error") })
  public ResponseEntity<ApiResponseBody<RegisterResponse>> registerPatient(
      @Valid @RequestBody RegisterRequest registerRequest) {

    RegisterResponse registerResponse = registerService.createPatient(registerRequest);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/auth/{username}")
        .buildAndExpand(registerResponse.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponseBody<>(true, "User registered successfully"));
  }
  
  @PostMapping("/patient/register-with-email-confirmation")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "Requested Resource Not Found"),
      @ApiResponse(code = 500, message = "Internal server error") })
  public ResponseEntity<ApiResponseBody<RegisterResponse>> registerPatientWithEmailConfirmation(@Valid @RequestBody RegisterRequest registerRequest) {

    RegisterResponse registerResponse = registerService.createUser(registerRequest);

    URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/v1/auth/{username}")
                .buildAndExpand(registerResponse.getUsername()).toUri();

    return ResponseEntity
        .created(location)
        .body(new ApiResponseBody<>(true, "User registered successfully"));
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
  public ResponseEntity<ApiResponseBody<RegisterResponse>> registerWithEmailConfirmation(RegisterRequest registerRequest) {

    var registerResponse = registerService.processConfirmationToken(registerRequest);

    return ResponseEntity.ok().body(new ApiResponseBody<RegisterResponse>(true, "A verification link has been sent to your email", registerResponse));
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
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {

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

          UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
          String accessToken = tokenService.generateToken(authentication, "");
          return ResponseEntity.ok(
              LoggedInUser.builder()
                  .id(userPrincipal.getId())
                  .username(userPrincipal.getUsername())
                  .email(userPrincipal.getEmail())
                  .roles(
                    userPrincipal.getAuthorities().stream().map(a -> {
                      return new LoggedInRole(a.getAuthority(), null);
                      })
                          .collect(Collectors.toSet())
                  )
                  .tokens(new LoggedInToken(accessToken, null))
                  .build()
          );

        } catch (Exception e) {
          log.error(e.getMessage(), e);
          return ResponseEntity.internalServerError().body(new ApiResponseBody<>(false, "You cannot login at this time, please try again later"));
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

  @GetMapping("/is-username-available")
  public boolean isUsernameAvailable() {
    return true;
  }

  // @PreAuthorize("isAnonymous()")
  // @GetMapping("/check-username-availability")
  //   public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
  //       Boolean isAvailable = !userRepository.existsByUsername(username);
  //       return new UserIdentityAvailability(isAvailable);
  //   }

  //   @GetMapping("/user/check-email-availability")
  //   public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
  //       Boolean isAvailable = !userRepository.existsByEmail(email);
  //       return new UserIdentityAvailability(isAvailable);
  //   }
}
