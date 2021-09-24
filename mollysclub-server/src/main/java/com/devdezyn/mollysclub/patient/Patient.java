package com.devdezyn.mollysclub.patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.devdezyn.mollysclub.patient_case.PatientCase;
import com.devdezyn.mollysclub.patient_test.PatientTest;
import com.devdezyn.mollysclub.prescription.Prescription;
import com.devdezyn.mollysclub.shared.models.BaseEntity;
import com.devdezyn.mollysclub.user.User;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Patient extends BaseEntity {
  private String insurance;

  private LocalDate birthday;

  private String gender;

  @OneToMany(cascade = CascadeType.ALL)
  private List<PatientCase> cases = new ArrayList<PatientCase>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<Prescription> prescriptions = new ArrayList<Prescription>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<PatientTest> tests = new ArrayList<PatientTest>();

  @OneToOne(cascade = CascadeType.ALL)
  private User user;

  @Builder
  public Patient(Long id, String insurance, LocalDate birthday, String gender, List<PatientCase> cases, List<Prescription> prescriptions, List<PatientTest> tests, User user) {
    super(id);
    this.insurance = insurance;
    this.birthday = birthday;
    this.gender = gender;
    this.cases = cases;
    this.prescriptions = prescriptions;
    this.tests = tests;
    this.user = user;
  }



}
