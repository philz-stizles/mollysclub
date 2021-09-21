package com.devdezyn.mollysclub.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements  PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientDto> findAll() {
        return patientRepository
                .findAll()
                .stream()
                .map(patient -> patientMapper.toDto(patient))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto findById(Long id) {
        return null;
    }

    @Override
    public PatientDto save(PatientDto dto) {
        return null;
    }
}
