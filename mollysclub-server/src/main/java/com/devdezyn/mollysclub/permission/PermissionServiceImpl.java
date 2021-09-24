package com.devdezyn.mollysclub.permission;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;


    public List<PermissionDto> getPermissions() {
        return permissionRepository.findAll().stream().map(p -> permissionMapper.toDto(p)).collect(Collectors.toList());
    }
    
    public Set<PermissionDto> getPermissionDtosByIds(Set<Long> ids) {
        return permissionRepository.findAllById(ids).stream().map(p -> permissionMapper.toDto(p)).collect(Collectors.toSet());
    }
    
     public List<Permission> getPermissionsByIds (Set<Long> ids) {
         return permissionRepository.findAllById(ids);
    }
}
