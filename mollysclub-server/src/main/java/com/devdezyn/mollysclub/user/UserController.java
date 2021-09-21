package com.devdezyn.mollysclub.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "User")
@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  

  @GetMapping
  @ApiOperation(value = "This will retrieve a list of categories", notes = "No implementation notes.")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "Requested Resource Not Found"),
          @ApiResponse(code = 500, message = "Internal server error")
  })
  public ResponseEntity<List<UserDto>> getUsers() {

    return new ResponseEntity<List<UserDto>>(userService.getUsers(), HttpStatus.OK);
  }

  @GetMapping(path="{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
    UserDto userDto = userService.getUserById(id);
    
    return ResponseEntity.ok().body(userDto);
  }
  
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    var createdUser = userService.saveUser(userDto);
    String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toUriString();
    URI uri = URI.create(uriString);
    return ResponseEntity.created(uri).body(createdUser);
  }

  @PostMapping(path="/role")
  public ResponseEntity<UserDto> addRoleToUser(@RequestBody AddRoleToUserDto dto) {
    userService.addRoleToUser(dto.getUsername(), dto.getRoleName());
    return ResponseEntity.ok().build();
  }
  
  @PutMapping(path="{id}")
  public String updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
    return "User is saved successfully";
  }
  
  @DeleteMapping(path="{id}")
  public String deleteUser(@PathVariable Long id) {
      return "User is saved successfully";
  }
}
