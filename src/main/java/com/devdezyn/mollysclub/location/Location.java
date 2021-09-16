package com.devdezyn.mollysclub.location;

import java.util.Date;

import javax.persistence.*;

import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.patient.Patient;

import lombok.Data;

@Data
@Entity
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long longitude;
  private Long latitude;
  private Date createdAt;
  private Date updatedAt;
}
