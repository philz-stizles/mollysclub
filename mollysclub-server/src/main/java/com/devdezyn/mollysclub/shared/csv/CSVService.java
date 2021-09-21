package com.devdezyn.mollysclub.shared.csv;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.devdezyn.mollysclub.patient.Patient;
import com.devdezyn.mollysclub.patient.PatientRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CSVService {
  private final PatientRepository patientRepository;

  public void save(MultipartFile file) {
    try {
      List<Patient> tutorials = CSVHelper.csvToPatients(file.getInputStream());
      patientRepository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Patient> tutorials = patientRepository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }

  public List<Patient> getAllPatients() {
    return patientRepository.findAll();
  }
}
