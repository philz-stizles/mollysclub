package com.devdezyn.mollysclub.address;

import java.util.List;

import com.devdezyn.mollysclub.shared.ApiBodyResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "Addresses")
@RestController
@RequestMapping(path = "/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
  private final AddressService addressService;
  
  @GetMapping
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<ApiBodyResponse<List<AddressDto>>> getAddresses() {
    List<AddressDto> addressDtos = addressService.findAll();
    String message = (addressDtos.size() <= 0) ? "No records found" : "Retrieved successfully";

    return ResponseEntity.ok().body(new ApiBodyResponse<>(true, message, addressDtos));
  }

  // @GetMapping(path="{id}")
  // public ResponseEntity<AddressDto> getAddress(@PathVariable Long id) {
  //   AddressDto addressDto = addressService.findManyByOwner(id);
    
  //   return new ResponseEntity<AddressDto>(addressDto, HttpStatus.OK);
  // }
  
  // @PostMapping
  // public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto dto) {
  //   AddressDto addressDto = addressService.createyByOwner(id);
    
  //   return new ResponseEntity<AddressDto>(addressDto, HttpStatus.CREATED);
  // }
  
  // @PutMapping(path="{id}")
  // public String updateAddress(@PathVariable Long id, @RequestBody AddressDto dto) {
  //   return "Address is saved successfully";
  // }
  
  // @DeleteMapping(path="{id}")
  // public String deleteAddress(@PathVariable Long id) {
  //     return "Address is saved successfully";
  // }
}
