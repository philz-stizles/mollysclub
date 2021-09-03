package com.devdezyn.mollysclub.converters.patient;

import com.devdezyn.mollysclub.api.dtos.PatientDto;
import com.devdezyn.mollysclub.domain.Patient;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PatientToPatientDto implements Converter<Patient, PatientDto> {

  @Nullable
  @Override
  public PatientDto convert(Patient source) {
    if (source == null) {
      return null;
    }

    final PatientDto patientDto = new PatientDto();

    return patientDto;
  }
  
}
