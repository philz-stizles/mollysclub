package com.devdezyn.mollysclub.services.permission;

import java.util.List;

import com.devdezyn.mollysclub.api.dtos.PermissionDto;

public interface PermissionService {
    List<PermissionDto> findAll();
    PermissionDto findById(Long id);
    PermissionDto save(PermissionDto dto);
}
