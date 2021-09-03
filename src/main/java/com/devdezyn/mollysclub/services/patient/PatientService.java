package com.devdezyn.mollysclub.services.patient;

import java.util.List;

import com.devdezyn.mollysclub.api.dtos.PatientDto;

public interface PatientService {
    List<PatientDto> findAll();
    PatientDto findById(Long id);
    PatientDto save(PatientDto dto);
}
