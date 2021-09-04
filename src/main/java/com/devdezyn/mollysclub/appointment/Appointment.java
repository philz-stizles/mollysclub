package com.devdezyn.mollysclub.appointment;

import java.util.Date;

import javax.persistence.*;

import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.patient.Patient;

import lombok.Data;

@Data
@Entity
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date when;
  private Date createdAt;
  private Date updatedAt;
  private AppointmentStatus status;

  @OneToOne
  private Doctor doctor;

  @OneToOne
  private Patient patient;
}
