package com.devdezyn.mollysclub.converters.patient;

import com.devdezyn.mollysclub.api.dtos.PatientDto;
import com.devdezyn.mollysclub.domain.Patient;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PatientDtoToPatient implements Converter<PatientDto, Patient> {

  @Nullable
  @Override
  public Patient convert(PatientDto source) {
    if (source == null) {
      return null;
    }

    final Patient patient = new Patient();

    return patient;
  }
  
}
