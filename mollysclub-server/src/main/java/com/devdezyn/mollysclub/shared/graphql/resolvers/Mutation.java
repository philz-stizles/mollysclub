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
  private DoctorRepository doctorRepository;

  public Patient createPatient(String name, Integer age) {
    Patient patient = new Patient();

    patientRepository.save(patient);

    return patient;
  }

  public Doctor createDoctor(String title, String description, Long patientId) {
    Doctor doctor = new Doctor();

    doctorRepository.save(doctor);

    return doctor;
  }

  // public boolean deleteDoctor(Long id) {
  //   doctorRepository.deleteById(id);
  //   return true;
  // }

  // public Doctor updateDoctor(Long id, String title, String description) throws NotFoundException {
  //   Optional<Doctor> optDoctor = doctorRepository.findById(id);

  //   if (optDoctor.isPresent()) {
  //     Doctor doctor = optDoctor.get();

  //     if (title != null)
         
  //     if (description != null)
         

  //     doctorRepository.save(doctor);
  //     return doctor;
  //   }

  //   throw new NotFoundException("Not found Doctor to update!");
  // }

}
