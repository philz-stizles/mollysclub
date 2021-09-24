package com.devdezyn.mollysclub.address;

import java.util.List;

import javax.validation.Valid;

import com.devdezyn.mollysclub.shared.ApiBodyResponse;
import com.devdezyn.mollysclub.shared.payloads.PagedResponse;
import com.devdezyn.mollysclub.shared.utils.AppConstants;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<ApiBodyResponse<List<AddressDto>>> getAllAddresses() {
    List<AddressDto> addressDtos = addressService.findAll();
    String message = (addressDtos.size() <= 0) ? "No records found" : "Retrieved successfully";

    return ResponseEntity.ok().body(new ApiBodyResponse<>(true, message, addressDtos));
  }

  @GetMapping(path = "/filtered")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<PagedResponse<AddressDto>> getFilteredAddresses(
    @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
    @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size
  ) {
    PagedResponse<AddressDto> pagedDtos = addressService.findFiltered(page, size);

    return ResponseEntity.ok().body(pagedDtos);
  }
  

  @GetMapping(path = "/{id}")
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<ApiBodyResponse<List<AddressDto>>> getAddress(@PathVariable @Valid Long id) {
    List<AddressDto> addressDtos = addressService.findAll();
    String message = (addressDtos.size() <= 0) ? "No records found" : "Retrieved successfully";

    return ResponseEntity.ok().body(new ApiBodyResponse<>(true, message, addressDtos));
  }

}
