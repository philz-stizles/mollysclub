package com.devdezyn.mollysclub.patient_case;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @RequiredArgsConstructor generates a constructor 
// with 1 parameter for each field that requires special handling. All 
// non-initialized final fields get a parameter, as well as any fields that 
// are marked as @NonNull that aren't initialized where they are declared. 
@Service
public class PatientCaseServiceImpl implements PatientCaseService {
  private final PatientCaseRepository appointmentRepository;

  @Override
  public List<PatientCaseDto> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<PatientCaseDto> getAllByDoctor(Long doctorId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<PatientCaseDto> getAllByPatient(Long patientId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<PatientCaseDto> getMany() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PatientCaseDto getById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PatientCaseDto getByDoctor(Long doctorId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PatientCaseDto getByPatient(Long patientId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PatientCaseDto getByDoctorPatient(Long patientId, Long doctorId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PatientCaseDto createByDoctor(PatientCaseDto patientCaseDto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PatientCaseDto updateByDoctor(PatientCaseDto patientCaseDto) {
    // TODO Auto-generated method stub
    return null;
  }
}
