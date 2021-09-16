package com.devdezyn.mollysclub.role;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Api(tags = "Role")
@RestController
@RequestMapping(path = "api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService RoleService;

    @GetMapping
    public ResponseEntity<List<RoleDto>> getRoles() {
        var roles = RoleService.getRoles();
        return ResponseEntity.ok().body(roles);
    }

    @PostMapping
    public ResponseEntity<List<RoleDto>> createRole() {
        var roles = RoleService.getRoles();
        return ResponseEntity.ok().body(roles);
    }

    @PutMapping
    public ResponseEntity<List<RoleDto>> updateRole() {
        var roles = RoleService.getRoles();
        return ResponseEntity.ok().body(roles);
    }

    @PutMapping(path="/archive")
    public ResponseEntity<List<RoleDto>> archiveRole() {
        var roles = RoleService.getRoles();
        return ResponseEntity.ok().body(roles);
    }
}
