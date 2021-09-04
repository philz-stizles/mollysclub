package com.devdezyn.mollysclub.appointment;

import java.util.List;

public interface AppointmentService {
  List<AppointmentDTO> getAll();
  AppointmentDTO getById(Long ownerId);
  AppointmentDTO create(Long creatorId, AppointmentDTO addressDTO);

  AppointmentDTO updateByCreator(Long creatorId, Long appointmentId, AppointmentDTO addressDTO);
  AppointmentDTO cancel(Long creatorId, Long appointmentId);
}
