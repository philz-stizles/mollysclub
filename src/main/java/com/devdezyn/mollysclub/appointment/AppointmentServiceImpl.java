package com.devdezyn.mollysclub.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentDAO addressDAO;
  
  @Autowired
  public AppointmentServiceImpl(AppointmentDAO addressDAO) {
    this.addressDAO = addressDAO;
  }

  @Override
  public List<AppointmentDTO> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDTO getById(Long ownerId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDTO create(Long creatorId, AppointmentDTO addressDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDTO updateByCreator(Long creatorId, Long appointmentId, AppointmentDTO addressDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppointmentDTO cancel(Long creatorId, Long appointmentId) {
    // TODO Auto-generated method stub
    return null;
  }
}
