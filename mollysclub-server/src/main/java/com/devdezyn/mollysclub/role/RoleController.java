package com.devdezyn.mollysclub.role;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.devdezyn.mollysclub.shared.ApiResponseBody;

@Api(tags = "Role")
@RestController
@RequestMapping(path = "api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService RoleService;

    @GetMapping
    public ResponseEntity<ApiResponseBody<List<RoleDto>>> getRoles() {
        var roles = RoleService.getRoles();
        return ResponseEntity.ok().body(new ApiResponseBody<>(true, "Retrieved successfully", roles));
    }

    @PostMapping
    public ResponseEntity<ApiResponseBody<RoleDto>> createRole(@RequestBody RoleRequest roleRequest) {
        RoleDto createdRoleDto = RoleService.createRole(roleRequest);
        return ResponseEntity.ok().body(new ApiResponseBody<>(true, "Retrieved successfully", createdRoleDto));
    }

    @PutMapping( path="/{id}")
    public ResponseEntity<ApiResponseBody<RoleDto>> updateRole(@PathVariable Long id, @RequestBody RoleRequest roleRequest) {
        RoleDto updatedRoleDto = RoleService.updateRole(id, roleRequest);
        return ResponseEntity.ok().body(new ApiResponseBody<>(true, "Retrieved successfully", updatedRoleDto));
    }
    

    @PutMapping(path="/archive")
    public ResponseEntity<List<RoleDto>> archiveRole() {
        var roles = RoleService.getRoles();
        return ResponseEntity.ok().body(roles);
    }
}
