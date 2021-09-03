package com.devdezyn.mollysclub.auth;

import org.springframework.web.bind.annotation.RestController;

import com.devdezyn.mollysclub.patient.PatientDto;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

  // @GetMapping
  // @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  // @ApiResponses(value = {
  //         @ApiResponse(code = 200, message = "Successfully retrieved list"),
  //         @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
  //         @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
  //         @ApiResponse(code = 404, message = "Requested Resource Not Found"),
  //         @ApiResponse(code = 500, message = "Internal server error")
  // })
  // public ResponseEntity<List<PatientDto>> activateAccount() {

  //   return new ResponseEntity<List<PatientDto>>(patientService.findAll(), HttpStatus.OK);
  // }
  
  // @GetMapping
  // @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  // @ApiResponses(value = {
  //         @ApiResponse(code = 200, message = "Successfully retrieved list"),
  //         @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
  //         @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
  //         @ApiResponse(code = 404, message = "Requested Resource Not Found"),
  //         @ApiResponse(code = 500, message = "Internal server error")
  // })
  // public ResponseEntity<List<PatientDto>> login() {

  //   return new ResponseEntity<List<PatientDto>>(patientService.findAll(), HttpStatus.OK);
  // }
}
