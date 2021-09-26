package com.devdezyn.mollysclub.pharmacy;

import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.auth.models.UserPrincipal;
import com.devdezyn.mollysclub.auth.security.CurrentUser;
import com.devdezyn.mollysclub.shared.ApiResponseBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Pharmacy")
@RestController
@RequestMapping(path = "/api/pharmacies")
@RequiredArgsConstructor
public class PharmacyController {
  private PharmacyService pharmacyService;

  @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
  @GetMapping
  @ApiOperation(value = "This will retrieve a list of pharmacies", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<List<PharmacyDto>> getPharmacies() {

    return new ResponseEntity<List<PharmacyDto>>(pharmacyService.getFilteredPharmacies(), HttpStatus.OK);
  }

  @GetMapping(path = "/{pharmacyId}")
  @ApiOperation(value = "This will a pharmacy by an id", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<PharmacyDto> getPharmacy(@Valid @PathVariable Long pharmacyId) {

    return new ResponseEntity<PharmacyDto>(pharmacyService.getPharmacy(pharmacyId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<PharmacyDto> createPharmacy(@CurrentUser UserPrincipal currentUser, @RequestBody PharmacyDto pharmacyDto) {
    return new ResponseEntity<PharmacyDto>(pharmacyService.createPharmacy(currentUser, pharmacyDto), HttpStatus.OK);
  }
  
  @PutMapping(path="/{pharmacyId}")
  public ResponseEntity<PharmacyDto> updatePharmacy(@CurrentUser UserPrincipal currentUser, @PathVariable Long pharmacyId, @RequestBody PharmacyDto pharmacyDto) {
    return new ResponseEntity<PharmacyDto>(pharmacyService.updatePharmacy(currentUser, pharmacyId, pharmacyDto), HttpStatus.OK);
  }
  
  @DeleteMapping(path="/{pharmacyId}")
  public ResponseEntity<PharmacyDto> deletePharmacy(@CurrentUser UserPrincipal currentUser, @Valid @PathVariable Long pharmacyId) {
      return new ResponseEntity<PharmacyDto>(pharmacyService.archivePharmacy(currentUser, pharmacyId), HttpStatus.OK);
  }

  @PostMapping(path = "/{pharmacyId}/addresses")
  @ApiOperation(value = "This will create a new address for a pharmacy with the given id", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })

  public ResponseEntity<ApiResponseBody<AddressDto>> addPharmacyAddress(
    @CurrentUser UserPrincipal currentUser,
    @PathVariable @Valid Long pharmacyId, 
    @RequestBody @Valid AddressDto addressDto
  ) {
    AddressDto addressDtos = pharmacyService.addPharmacyAddress(currentUser, pharmacyId, addressDto);

    return ResponseEntity.ok().body(new ApiResponseBody<>(true, "Created successfully", addressDtos));
  }
  
  @PutMapping(path = "/{pharmacyId}/addresses/{addressId}")
  @ApiOperation(value = "This will update an existing address for a pharmacy with the given id", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully updated address"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<ApiResponseBody<AddressDto>> updatePharmacyAddress(
    @CurrentUser UserPrincipal currentUser,
    @PathVariable @Valid Long pharmacyId, 
    @PathVariable @Valid Long addressId, 
    @RequestBody @Valid AddressDto addressDto
  ) {
    AddressDto updatedAddressDto = pharmacyService.updatePharmacyAddress(currentUser, pharmacyId, addressId, addressDto);

    return ResponseEntity.ok().body(new ApiResponseBody<>(true, "Updated successfully", updatedAddressDto));
  }

  @DeleteMapping(path = "/{pharmacyId}/addresses/{addressId}")
  @ApiOperation(value = "This will update an existing address for a pharmacy with the given id", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully updated address"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<ApiResponseBody<AddressDto>> deletePharmacyAddress(
    @CurrentUser UserPrincipal currentUser,
    @PathVariable @Valid Long pharmacyId, 
    @PathVariable @Valid Long addressId
  ) {
    AddressDto addressDto = pharmacyService.deletePharmacyAddress(currentUser, pharmacyId, addressId);

    return ResponseEntity.ok().body(new ApiResponseBody<>(true, "Updated successfully", addressDto));
  }
}
