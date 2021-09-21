package com.devdezyn.mollysclub.shared.graphql.resolvers;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.doctor.DoctorRepository;
import com.devdezyn.mollysclub.patient.Patient;
import com.devdezyn.mollysclub.patient.PatientRepository;

import org.springframework.stereotype.Component;

import javassist.NotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
  private PatientRepository patientRepository;
  private DoctorRepository tutorialRepository;

  public Patient createPatient(String name, Integer age) {
    Patient patient = new Patient();

    patientRepository.save(patient);

    return patient;
  }

  public Doctor createDoctor(String title, String description, Long patientId) {
    Doctor tutorial = new Doctor();

    tutorialRepository.save(tutorial);

    return tutorial;
  }

  public boolean deleteDoctor(Long id) {
    tutorialRepository.deleteById(id);
    return true;
  }

  public Doctor updateDoctor(Long id, String title, String description) throws NotFoundException {
    Optional<Doctor> optDoctor = tutorialRepository.findById(id);

    if (optDoctor.isPresent()) {
      Doctor tutorial = optDoctor.get();

      if (title != null)
         
      if (description != null)
         

      tutorialRepository.save(tutorial);
      return tutorial;
    }

    throw new NotFoundException("Not found Doctor to update!");
  }

}
