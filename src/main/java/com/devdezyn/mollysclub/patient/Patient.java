package com.devdezyn.mollysclub.patient;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.patient_case.PatientCase;
import com.devdezyn.mollysclub.patient_test.PatientTest;
import com.devdezyn.mollysclub.prescription.Prescription;
import com.devdezyn.mollysclub.user.User;

import lombok.Data;

@Data
@Entity
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Address> addresses = new ArrayList<Address>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<PatientCase> cases = new ArrayList<PatientCase>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<Prescription> prescriptions = new ArrayList<Prescription>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<PatientTest> tests = new ArrayList<PatientTest>();

  @OneToOne(cascade = CascadeType.ALL)
  private User account;
}
