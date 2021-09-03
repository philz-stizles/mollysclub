package com.devdezyn.mollysclub.services.patient;

import com.devdezyn.mollysclub.api.dtos.PatientDto;
import com.devdezyn.mollysclub.converters.patient.PatientDtoToPatient;
import com.devdezyn.mollysclub.converters.patient.PatientToPatientDto;
import com.devdezyn.mollysclub.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements  PatientService {

    private final PatientRepository patientRepository;
    private final PatientDtoToPatient patientDtoToPatient;
    private final PatientToPatientDto patientToPatientDto;

    @Autowired
    public PatientServiceImpl(
            PatientRepository patientRepository, 
            PatientDtoToPatient patientDtoToPatient, 
            PatientToPatientDto patientToPatientDto) {
        this.patientRepository = patientRepository;
        this.patientDtoToPatient = patientDtoToPatient;
        this.patientToPatientDto = patientToPatientDto;
    }

    @Override
    public List<PatientDto> findAll() {
        return patientRepository
                .findAll()
                .stream()
                .map(patient -> patientToPatientDto.convert(patient))
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
