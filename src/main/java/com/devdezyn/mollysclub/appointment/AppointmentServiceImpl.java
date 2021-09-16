package com.devdezyn.mollysclub.appointment;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @RequiredArgsConstructor generates a constructor 
// with 1 parameter for each field that requires special handling. All 
// non-initialized final fields get a parameter, as well as any fields that 
// are marked as @NonNull that aren't initialized where they are declared. 
@Service
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentRepository appointmentRepository;

  @Override
  public List<AppointmentDto> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDto getById(Long ownerId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDto create(Long creatorId, AppointmentDto appointmentDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDto updateByCreator(Long creatorId, Long appointmentId, AppointmentDto appointmentDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDto cancel(Long creatorId, Long appointmentId) {
    // TODO Auto-generated method stub
    return null;
  }
}
