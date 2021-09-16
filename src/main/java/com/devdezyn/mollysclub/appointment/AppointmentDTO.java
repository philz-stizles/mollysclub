package com.devdezyn.mollysclub.appointment;

import java.util.Date;

import lombok.Data;

@Data
public class AppointmentDto {
  private Long id;
  private String mandate;
  private Date when;
  private Long doctorId;
  private Long patientId;
  private Date createdAt;
  private Date updatedAt;
  private AppointmentStatus status;
}
