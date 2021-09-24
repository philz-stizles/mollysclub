package com.devdezyn.mollysclub.permission;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Api(tags = "Permission")
@RestController
@RequestMapping(path = "api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<PermissionDto>> getPermissions() {
        var permissions = permissionService.getPermissions();
        return ResponseEntity.ok().body(permissions);
    }
}
