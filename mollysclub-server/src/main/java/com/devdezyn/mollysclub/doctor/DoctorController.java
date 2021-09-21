package com.devdezyn.mollysclub.doctor;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;

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

@Api(tags = "Doctor")
@RestController
@RequestMapping(path="/api/doctors")
public class DoctorController {
  private final DoctorService doctorService;
  
  @Autowired
  public DoctorController(DoctorService doctorService) {
    this.doctorService = doctorService;
  }
  

  @GetMapping
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public String getDoctors() {

    return "Doctor is saved successfully";
  }

  @GetMapping(path="{id}")
  public String getDoctor(@PathVariable Long id) {
    return "Doctor is saved successfully";
    
    // return new ResponseEntity<DoctorDto>(doctorDto, HttpStatus.OK);
  }
  
  @PostMapping
  public String createDoctor(@RequestBody DoctorDto doctorDto) {
    return "Doctor is saved successfully";
  }
  
  @PutMapping(path="{id}")
  public String updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
    return "Doctor is saved successfully";
  }
  
  @DeleteMapping(path="{id}")
  public String deleteDoctor(@PathVariable Long id) {
      return "Doctor is saved successfully";
  }
}
