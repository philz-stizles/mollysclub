package com.devdezyn.mollysclub.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDAO extends JpaRepository<Appointment, Long> {
  
}
