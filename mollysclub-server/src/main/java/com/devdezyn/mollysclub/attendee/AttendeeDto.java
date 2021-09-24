package com.devdezyn.mollysclub.attendee;

import java.util.Date;

import lombok.Data;

@Data
public class AttendeeDto {
  private Long id;
  private String mandate;
  private Date when;
  private Long doctorId;
  private Long patientId;
  private Date createdAt;
  private Date updatedAt;
  private AttendeeStatus status;
}
