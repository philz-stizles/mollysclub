package com.devdezyn.mollysclub.domain;

import java.util.Date;

import javax.persistence.*;

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
