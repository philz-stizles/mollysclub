// package com.devdezyn.mollysclub.permission.services;

// import com.devdezyn.mollysclub.permission.PermissionDto;
// import com.devdezyn.mollysclub.permission.converters.PermissionDtoToPermission;
// import com.devdezyn.mollysclub.permission.converters.PermissionToPermissionDto;
// import com.devdezyn.mollysclub.permission.converters.permission.*;
// import com.devdezyn.mollysclub.repositories.PermissionRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class PermissionServiceImpl implements  PermissionService {

//     private final PermissionRepository permissionRepository;
//     private final PermissionDtoToPermission permissionDtoToPermission;
//     private final PermissionToPermissionDto permissionToPermissionDto;

//     @Autowired
//     public PermissionServiceImpl(
//             PermissionRepository permissionRepository, 
//             PermissionDtoToPermission permissionDtoToPermission, 
//             PermissionToPermissionDto permissionToPermissionDto) {
//         this.permissionRepository = permissionRepository;
//         this.permissionDtoToPermission = permissionDtoToPermission;
//         this.permissionToPermissionDto = permissionToPermissionDto;
//     }

//     @Override
//     public List<PermissionDto> findAll() {
//         return permissionRepository
//                 .findAll()
//                 .stream()
//                 .map(permission -> permissionToPermissionDto.convert(permission))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public PermissionDto findById(Long id) {
//         return null;
//     }

//     @Override
//     public PermissionDto save(PermissionDto dto) {
//         return null;
//     }
// }
