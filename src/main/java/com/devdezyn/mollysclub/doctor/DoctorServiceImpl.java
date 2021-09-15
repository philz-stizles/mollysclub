package com.devdezyn.mollysclub.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public List<DoctorDto> findAll() {
        return doctorRepository.findAll()
            .stream()
            .map(a -> doctorMapper.toDto(a))
            .collect(Collectors.toList());
    }

    public DoctorDto create(DoctorDto doctorDto) {
        // Optional<Doctor> existingDoctor = doctorRepository.findByEmail(doctor.getEmail());
        // if(existingDoctor.isPresent()) {
        //     throw new IllegalStateException("Email is already taken");
        // }

        // return doctorRepository.save(doctor);
        return null;
    }

    public Optional<DoctorDto> findById (Long id) {
        // return doctorRepository.findById(id);
        return null;
    }

    public Optional<DoctorDto> findByEmail (String email) {
        // return doctorRepository.findByEmail(email);

        return null;
    }

    public void deleteById (Long id) {
        boolean exists = doctorRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Doctor not found");
        }

        doctorRepository.deleteById(id);
    }

    @Transactional
    public void updateById(DoctorDto doctorDto) {

    }
}
