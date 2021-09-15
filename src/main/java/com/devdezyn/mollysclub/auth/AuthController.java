package com.devdezyn.mollysclub.auth;

import org.springframework.web.bind.annotation.RestController;

import com.devdezyn.mollysclub.auth.login.LoginRequest;
import com.devdezyn.mollysclub.auth.registration.*;
import com.devdezyn.mollysclub.auth.token.JwtAuthenticationResponse;
import com.devdezyn.mollysclub.auth.token.JwtTokenProvider;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "Authentication")
@RestController
@RequestMapping(path = "/api/v1/auth")
@AllArgsConstructor
public class AuthController {
  private final RegistrationService registrationService;
  private final JwtTokenProvider tokenProvider;
  private final AuthenticationManager authenticationManager;


  // @Autowired
  // private final AuthenticationManager authenticationManager = new AuthenticationManager();
  
  @PostMapping("/register")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public String register(@RequestBody RegisterRequest registerRequest) {

    return registrationService.register(registerRequest);
  }

  // @PostMapping("/registerWithEmailConfirmation")
  // @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  // @ApiResponses(value = {
  //         @ApiResponse(code = 200, message = "Successfully retrieved list"),
  //         @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
  //         @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
  //         @ApiResponse(code = 404, message = "Requested Resource Not Found"),
  //         @ApiResponse(code = 500, message = "Internal server error")
  // })
  // public ResponseEntity<List<PatientDto>> registerWithEmailConfirmation() {

  //   return new ResponseEntity<List<PatientDto>>(patientService.findAll(), HttpStatus.OK);
  // }

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
    return registrationService.confirmToken(token);
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
  public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(), 
                loginRequest.getPassword()
            )
        );

        SecurityContextHolder
            .getContext()
            .setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
  }
}
