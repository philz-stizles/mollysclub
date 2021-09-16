package com.devdezyn.mollysclub.patient;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAll();
    PatientDto findById(Long id);
    PatientDto save(PatientDto dto);
}
