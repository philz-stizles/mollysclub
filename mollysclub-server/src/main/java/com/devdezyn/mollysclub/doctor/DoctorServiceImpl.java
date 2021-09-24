package com.devdezyn.mollysclub.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.devdezyn.mollysclub.shared.utils.SearchCriteria;
import com.devdezyn.mollysclub.user.User;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public List<DoctorDto> findAll() {
        return doctorRepository.findAll().stream().map(a -> doctorMapper.toDto(a)).collect(Collectors.toList());
    }
    
    public List<DoctorDto> searchDoctors(DoctorSearchRequest request) {
        DoctorSpecification spec1 = new DoctorSpecification(
                new SearchCriteria("firstName", ":", request.getSearch())
        );
        DoctorSpecification spec2 = new DoctorSpecification(
                new SearchCriteria("lastName", ":", request.getSearch())
        );
        // DoctorSpecification spec2 = 
        // new DoctorSpecification(new SearchCriteria("lastName", ":", "doe"));

        // List<User> results = 
    //   repository.findAll(Specification.where(spec1).and(spec2));
    return doctorRepository.findAll(Specification.where(spec1).and(spec2)).stream().map(d -> {
        return doctorMapper.toDto(d);
        }).collect(Collectors.toList());


    
    }

    public DoctorDto create(User user) {
        var createdDoctor =  doctorRepository.save(Doctor.builder().user(user).build());
        return doctorMapper.toDto(createdDoctor);
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

    @Override
    public void updateByUser(DoctorDto doctorDto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<DoctorDto> getAppointments(String email) {
        // TODO Auto-generated method stub
        return null;
    }
}
