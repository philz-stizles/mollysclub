package com.devdezyn.mollysclub.prescription;

import com.devdezyn.mollysclub.doctor.DoctorDto;
import com.devdezyn.mollysclub.patient.PatientDto;

import lombok.Data;

@Data
public class PrescriptionDto {
  private Long id;
  
  private String content;

  private DoctorDto prescribedBy;

  private PatientDto prescribedFor;
}
