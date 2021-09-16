package com.devdezyn.mollysclub.prescription;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Prescriptions")
@RestController
@RequestMapping(path = "/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {
  private PrescriptionService prescriptionService;

  @GetMapping
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<List<PrescriptionDto>> getPrescriptions() {

    return new ResponseEntity<List<PrescriptionDto>>(prescriptionService.getPrescriptions(), HttpStatus.OK);
  }

  // @GetMapping(path="{id}")
  // public ResponseEntity<PrescriptionDto> getPrescription(@PathVariable Long id) {
  //   PrescriptionDto prescriptionDto = prescriptionService.getPrescriptions();
    
  //   return new ResponseEntity<PrescriptionDto>(prescriptionDto, HttpStatus.OK);
  // }
  
  // @PostMapping
  // public String createPrescription(@RequestBody PrescriptionDto categoryDTO) {
  //   return "Prescription is saved successfully";
  // }
  
  // @PutMapping(path="{id}")
  // public String updatePrescription(@PathVariable Long id, @RequestBody PrescriptionDto categoryDTO) {
  //   return "Prescription is saved successfully";
  // }
  
  // @DeleteMapping(path="{id}")
  // public String deletePrescription(@PathVariable Long id) {
  //     return "Prescription is saved successfully";
  // }
}
