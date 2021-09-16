// package com.devdezyn.mollysclub.api.controller;

// import org.springframework.web.bind.annotation.RestController;

// import com.devdezyn.mollysclub.api.dtos.GymnDto;
// import com.devdezyn.mollysclub.services.gymn.GymnService;

// import io.swagger.annotations.*;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
// @RequestMapping(path="/api/gymns")
// public class GymnController {
//   private GymnService gymnService;
  
//   @Autowired
//   public GymnController(GymnService gymnService) {
//     this.gymnService = gymnService;
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
//   public ResponseEntity<List<GymnDto>> getGymns() {

//     return new ResponseEntity<List<GymnDto>>(gymnService.findAll(), HttpStatus.OK);
//   }

//   @GetMapping(path="{id}")
//   public ResponseEntity<GymnDto> getGymn(@PathVariable Long id) {
//     GymnDto gymnDto = gymnService.findById(id);
    
//     return new ResponseEntity<GymnDto>(gymnDto, HttpStatus.OK);
//   }
  
//   @PostMapping
//   public String createGymn(@RequestBody GymnDto gymnDto) {
//     return "Gymn is saved successfully";
//   }
  
//   @PutMapping(path="{id}")
//   public String updateGymn(@PathVariable Long id, @RequestBody GymnDto gymnDto) {
//     return "Gymn is saved successfully";
//   }
  
//   @DeleteMapping(path="{id}")
//   public String deleteGymn(@PathVariable Long id) {
//       return "Gymn is saved successfully";
//   }
// }
