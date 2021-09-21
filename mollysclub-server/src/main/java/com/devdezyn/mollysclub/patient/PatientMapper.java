package com.devdezyn.mollysclub.patient;

import java.util.stream.Collectors;

import com.devdezyn.mollysclub.prescription.PrescriptionMapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PatientMapper {
    private final PrescriptionMapper prescriptionMapper;

    public PatientDto toDto(Patient entity) {
        if(entity == null) return null;

        PatientDto dto = new PatientDto();
        dto.setId(entity.getId());

        var prescriptions = entity.getPrescriptions()
            .stream()
            .map(e -> prescriptionMapper.toDto(e))
            .collect(Collectors.toList());
        dto.setPrescriptions(prescriptions);

        return dto;
    }

    public Patient toEntity(PatientDto dto) {
        if (dto == null)
            return null;
        
        Patient entity = new Patient();
        entity.setId(dto.getId());

        return entity;
    }
}