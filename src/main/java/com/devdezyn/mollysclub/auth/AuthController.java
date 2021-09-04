package com.devdezyn.mollysclub.auth;

import org.springframework.web.bind.annotation.RestController;

import com.devdezyn.mollysclub.auth.registration.RegisterRequest;
import com.devdezyn.mollysclub.auth.registration.RegistrationService;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/api/v1/auth")
@AllArgsConstructor
public class AuthController {
  private RegistrationService registrationService;
  
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

  // @PostMapping("/registerWithActivation")
  // @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  // @ApiResponses(value = {
  //         @ApiResponse(code = 200, message = "Successfully retrieved list"),
  //         @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
  //         @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
  //         @ApiResponse(code = 404, message = "Requested Resource Not Found"),
  //         @ApiResponse(code = 500, message = "Internal server error")
  // })
  // public ResponseEntity<List<PatientDto>> registerWithActivation() {

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
  public ResponseEntity<String> login() {

    return new ResponseEntity<String>("Login", HttpStatus.OK);
  }
}
