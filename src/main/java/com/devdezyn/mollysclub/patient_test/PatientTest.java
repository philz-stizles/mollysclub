package com.devdezyn.mollysclub.patient_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.patient.Patient;

import lombok.Data;

@Data
@Entity
public class PatientTest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String type;

  private String description;

  private String report;
  
  private Date createdAt;
  private Date updatedAt;
  private PatientTestStatus status;

  @OneToOne
  private Doctor doctor;

  @OneToOne
  private Patient patient;
}
