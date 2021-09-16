package com.devdezyn.mollysclub.patient_case;

// import com.devdezyn.mollysclub.shared.BaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientCaseRepository extends JpaRepository<PatientCase, Long> {
  
}
