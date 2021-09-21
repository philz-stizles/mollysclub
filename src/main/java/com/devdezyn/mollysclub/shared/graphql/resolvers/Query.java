package com.devdezyn.mollysclub.shared.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.doctor.DoctorRepository;
import com.devdezyn.mollysclub.patient.Patient;
import com.devdezyn.mollysclub.patient.PatientRepository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
  private PatientRepository patientRepository;
  private DoctorRepository tutorialRepository;

  public Iterable<Patient> findAllPatients() {
    return patientRepository.findAll();
  }

  public Iterable<Doctor> findAllDoctors() {
    return tutorialRepository.findAll();
  }

  public long countPatients() {
    return patientRepository.count();
  }

  public long countDoctors() {
    return tutorialRepository.count();
  }

}
