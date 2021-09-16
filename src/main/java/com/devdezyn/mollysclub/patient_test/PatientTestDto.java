package com.devdezyn.mollysclub.patient_test;

import java.util.Date;

import lombok.Data;

@Data
public class PatientTestDto {
  private Long id;

  private Date when;
  private Long doctorId;
  private Long patientId;
  private Date createdAt;
  private Date updatedAt;
  private PatientTestStatus status;
}
