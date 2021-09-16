package com.devdezyn.mollysclub.patient_case;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.patient.Patient;
import com.devdezyn.mollysclub.patient_test.PatientTest;
import com.devdezyn.mollysclub.prescription.Prescription;

import lombok.Data;

@Data
@Entity
public class PatientCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date createdAt;
  private Date updatedAt;
  private PatientCaseStatus status;

  @OneToOne
  private Doctor doctor;

  @OneToOne
  private Patient patient;

  @OneToMany(cascade = CascadeType.ALL)
  private List<PatientTest> tests = new ArrayList<PatientTest>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<Prescription> prescriptions = new ArrayList<Prescription>();
}
