package com.devdezyn.mollysclub.appointment;

import java.util.Date;

import lombok.Data;

@Data
public class AppointmentDTO {
  private Long id;

  private Date when;
  private Date updatedAt;
  private Long doctorId;
  private Long patientId;
}
