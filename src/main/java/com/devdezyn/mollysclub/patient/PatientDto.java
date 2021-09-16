package com.devdezyn.mollysclub.patient;

import java.util.List;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.patient_case.PatientCaseDto;
import com.devdezyn.mollysclub.patient_test.PatientTestDto;
import com.devdezyn.mollysclub.prescription.PrescriptionDto;
import com.devdezyn.mollysclub.user.UserDto;

import lombok.Data;

@Data
public class PatientDto {
  private Long id;
  private List<AddressDto> addresses;
  private List<PatientCaseDto> cases;
  private List<PrescriptionDto> prescriptions;
  private List<PatientTestDto> tests;
  private UserDto account;
}
