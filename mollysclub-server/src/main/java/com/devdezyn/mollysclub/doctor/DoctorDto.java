package com.devdezyn.mollysclub.doctor;

import com.devdezyn.mollysclub.user.UserDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDto {
  private Long id;
  private String specialization;
  private String mobile;
  private String gender;
  private String email;
  private Integer age;
  private UserDto user;;
}
