package com.devdezyn.mollysclub.doctor;

import lombok.*;

@Data
public class DoctorDto {
  private Long id;
  private String specialization;
  private String mobile;
  private String gender;
  private String email;
  private Integer age;
}
