package com.devdezyn.mollysclub.appointment;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Appointment")
@RestController
@RequestMapping(path = "/api/v1/appointments")
@Validated // class level
public class AppointmentController {
  private AppointmentService appointmentService;
  
  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }
  

  @GetMapping
  @ApiOperation(value = "This will retrieve a list of appointments", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<List<AppointmentDto>> getAll() {

    return new ResponseEntity<List<AppointmentDto>>(appointmentService.findAll(), HttpStatus.OK);
  }

  @GetMapping(path="{id}")
  public ResponseEntity<AppointmentDto> get(@PathVariable @Min(1) Long id) {
    AppointmentDto appointmentDto = appointmentService.findById(id);
    
    return ResponseEntity.status(HttpStatus.OK).body(appointmentDto);
  }
  
  // @PostMapping
  // public String createPatient(@RequestBody AppointmentDto categoryDTO) {
  //   return "Patient is saved successfully";
  // }
  
  // @PutMapping(path="{id}")
  // public String updatePatient(@PathVariable Long id, @RequestBody AppointmentDto categoryDTO) {
  //   return "Patient is saved successfully";
  // }
  
  // @DeleteMapping(path="{id}")
  // public String deletePatient(@PathVariable Long id) {
  //     return "Patient is saved successfully";
  // }
}
