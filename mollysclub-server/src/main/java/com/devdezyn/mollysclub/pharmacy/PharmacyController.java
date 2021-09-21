package com.devdezyn.mollysclub.pharmacy;

import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Pharmacy")
@RestController
@RequestMapping(path="/api/pharmacies")
public class PharmacyController {
//   private PatientService patientService;
  
//   @Autowired
//   public PharmacyController(PatientService patientService) {
//     this.patientService = patientService;
//   }
  

//   @GetMapping
//   @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
//   @ApiResponses(value = {
//           @ApiResponse(code = 200, message = "Successfully retrieved list"),
//           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//           @ApiResponse(code = 404, message = "Requested Resource Not Found"),
//           @ApiResponse(code = 500, message = "Internal server error")
//   })
//   public ResponseEntity<List<PatientDto>> getPatients() {

//     return new ResponseEntity<List<PatientDto>>(patientService.findAll(), HttpStatus.OK);
//   }

//   @GetMapping(path="{id}")
//   public ResponseEntity<PatientDto> getPatient(@PathVariable Long id) {
//     PatientDto patientDto = patientService.findById(id);
    
//     return new ResponseEntity<PatientDto>(patientDto, HttpStatus.OK);
//   }
  
//   @PostMapping
//   public String createPatient(@RequestBody PatientDto categoryDTO) {
//     return "Patient is saved successfully";
//   }
  
//   @PutMapping(path="{id}")
//   public String updatePatient(@PathVariable Long id, @RequestBody PatientDto categoryDTO) {
//     return "Patient is saved successfully";
//   }
  
//   @DeleteMapping(path="{id}")
//   public String deletePatient(@PathVariable Long id) {
//       return "Patient is saved successfully";
//   }
}
