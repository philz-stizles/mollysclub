package com.devdezyn.mollysclub.prescription;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.patient.Patient;

import lombok.Data;

@Data
@Entity
public class Prescription {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String content;

  @OneToOne(cascade = CascadeType.PERSIST)
  private Doctor prescribedBy;

  @OneToOne(cascade = CascadeType.PERSIST)
  private Patient prescribedFor;
}
