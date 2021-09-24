package com.devdezyn.mollysclub.attendee;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @RequiredArgsConstructor generates a constructor 
// with 1 parameter for each field that requires special handling. All 
// non-initialized final fields get a parameter, as well as any fields that 
// are marked as @NonNull that aren't initialized where they are declared. 
@Service
public class AttendeeServiceImpl implements AttendeeService {
  private final AttendeeRepository appointmentRepository;

  @Override
  public AttendeeDto create(AttendeeDto appointmentDTO) {
    return null;
  }

  @Override
  public List<AttendeeDto> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AttendeeDto findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AttendeeDto updateByCreator(Long creatorId, Long appointmentId, AttendeeDto appointmentDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AttendeeDto cancel(Long creatorId, Long appointmentId) {
    // TODO Auto-generated method stub
    return null;
  }
}
