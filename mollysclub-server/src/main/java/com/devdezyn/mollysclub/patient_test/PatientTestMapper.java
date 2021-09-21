// package com.devdezyn.mollysclub.appointment;

// import org.springframework.stereotype.Component;

// @Component
// public class PatientTestMapper {

//     public PatientCaseDto toDto(PatientTest entity) {
//         if(entity == null) return null;

//         PatientCaseDto dto = new PatientCaseDto();
//         dto.setId(entity.getId());
//         dto.setWhen(entity.getWhen());
//         dto.setStatus(entity.getStatus());
//         dto.setCreatedAt(entity.getCreatedAt());
//         dto.setUpdatedAt(entity.getUpdatedAt());

//         return dto;
//     }

//     public PatientTest toEntity(PatientCaseDto dto) {
//         if (dto == null)
//             return null;
        
//         PatientTest entity = new PatientTest();
//         entity.setId(dto.getId());
//         entity.setWhen(dto.getWhen());
//         entity.setStatus(dto.getStatus());
//         entity.setCreatedAt(dto.getCreatedAt());
//         entity.setUpdatedAt(dto.getUpdatedAt());

//         return entity;
//     }
// }