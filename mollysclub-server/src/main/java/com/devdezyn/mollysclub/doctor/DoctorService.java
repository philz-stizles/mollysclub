package com.devdezyn.mollysclub.doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public List<DoctorDto> findAll();

    public DoctorDto create(DoctorDto doctorDto);

    public Optional<DoctorDto> findById(Long id);

    public Optional<DoctorDto> findByEmail(String email);

    public void deleteById(Long id);

    public void updateById(DoctorDto doctorDto);
}
