package com.devdezyn.mollysclub.patient_test;

import java.util.List;

public interface PatientTestService {
  List<PatientTestDto> getAll();
  PatientTestDto getById(Long ownerId);
  PatientTestDto create(Long creatorId, PatientTestDto addressDTO);

  PatientTestDto updateByCreator(Long creatorId, Long appointmentId, PatientTestDto addressDTO);
  PatientTestDto cancel(Long creatorId, Long appointmentId);
}
