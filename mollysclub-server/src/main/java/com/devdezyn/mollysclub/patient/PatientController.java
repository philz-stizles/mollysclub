package com.devdezyn.mollysclub.patient;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Patients")
@RestController
@RequestMapping(path = "/api/patients")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;
  

  @GetMapping
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<List<PatientDto>> getPatients() {

    return new ResponseEntity<List<PatientDto>>(patientService.findAll(), HttpStatus.OK);
  }

  @GetMapping(path="{id}")
  public ResponseEntity<PatientDto> getPatient(@PathVariable Long id) {
    PatientDto patientDto = patientService.findById(id);
    
    return new ResponseEntity<PatientDto>(patientDto, HttpStatus.OK);
  }
  
  @PostMapping
  public String createPatient(@RequestBody PatientDto categoryDTO) {
    return "Patient is saved successfully";
  }
  
  @PutMapping(path="{id}")
  public String updatePatient(@PathVariable Long id, @RequestBody PatientDto categoryDTO) {
    return "Patient is saved successfully";
  }
  
  @DeleteMapping(path="{id}")
  public String deletePatient(@PathVariable Long id) {
    return "Patient is saved successfully";
  }

  // @PostMapping("/upload")
  // public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
  //   String message = "";

  //   if (CSVHelper.hasCSVFormat(file)) {
  //     try {
  //       fileService.save(file);

  //       message = "Uploaded the file successfully: " + file.getOriginalFilename();
  //       return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
  //     } catch (Exception e) {
  //       message = "Could not upload the file: " + file.getOriginalFilename() + "!";
  //       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
  //     }
  //   }

  //   message = "Please upload a csv file!";
  //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  // }
  
  // @GetMapping("/download")
  // public ResponseEntity<Resource> getFile() {
  //   String filename = "tutorials.csv";
  //   InputStreamResource file = new InputStreamResource(fileService.load());

  //   return ResponseEntity.ok()
  //       .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
  //       .contentType(MediaType.parseMediaType("application/csv"))
  //       .body(file);
  // }
}
