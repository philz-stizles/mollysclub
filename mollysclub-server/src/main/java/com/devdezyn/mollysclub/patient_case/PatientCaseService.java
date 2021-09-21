package com.devdezyn.mollysclub.patient_case;

import java.util.List;

public interface PatientCaseService {
  List<PatientCaseDto> getAll();

  List<PatientCaseDto> getAllByDoctor(Long doctorId);

  List<PatientCaseDto> getAllByPatient(Long patientId);

  List<PatientCaseDto> getMany();

  PatientCaseDto getById(Long id);

  PatientCaseDto getByDoctor(Long doctorId);

  PatientCaseDto getByPatient(Long patientId);

  PatientCaseDto getByDoctorPatient(Long patientId, Long doctorId);

  PatientCaseDto createByDoctor(PatientCaseDto patientCaseDto);

  PatientCaseDto updateByDoctor(PatientCaseDto patientCaseDto);
}
