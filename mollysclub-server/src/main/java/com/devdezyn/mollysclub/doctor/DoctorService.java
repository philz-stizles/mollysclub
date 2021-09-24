package com.devdezyn.mollysclub.doctor;

import java.util.List;
import java.util.Optional;

import com.devdezyn.mollysclub.user.User;

public interface DoctorService {
    public List<DoctorDto> findAll();

    public DoctorDto create(User user);

    public Optional<DoctorDto> findById(Long id);

    public Optional<DoctorDto> findByEmail(String email);

    public void deleteById(Long id);

    public void updateById(DoctorDto doctorDto);

    public void updateByUser(DoctorDto doctorDto);

    public Optional<DoctorDto> getAppointments(String email);
}
