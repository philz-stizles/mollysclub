package com.devdezyn.mollysclub.attendee;

import java.util.List;

public interface AttendeeService {
  List<AttendeeDto> findAll();
  AttendeeDto findById(Long id);
  AttendeeDto create(AttendeeDto appointmentDto);

  AttendeeDto updateByCreator(Long creatorId, Long appointmentId, AttendeeDto addressDTO);
  AttendeeDto cancel(Long creatorId, Long appointmentId);
}
