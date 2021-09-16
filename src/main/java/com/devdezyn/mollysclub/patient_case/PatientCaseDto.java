package com.devdezyn.mollysclub.patient_case;

import java.util.Date;
import java.util.List;

import com.devdezyn.mollysclub.doctor.DoctorDto;
import com.devdezyn.mollysclub.patient.PatientDto;
import com.devdezyn.mollysclub.patient_test.PatientTestDto;
import com.devdezyn.mollysclub.prescription.PrescriptionDto;

import lombok.Data;

@Data
public class PatientCaseDto {
  private Long id;

  private Date createdAt;
  private Date updatedAt;
  private PatientCaseStatus status;
  private DoctorDto doctor;
  private PatientDto patient;
  private List<PatientTestDto> tests;
  private List<PrescriptionDto> prescriptions;
}
