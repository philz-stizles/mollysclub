package com.devdezyn.mollysclub.pharmacy;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService{
    private final PharmacyRepository permissionRepository;
    private final PharmacyMapper permissionMapper;


    public List<PharmacyDto> getPharmacies () {
        return permissionRepository.findAll()
        .stream().map(p -> permissionMapper.toDto(p)).collect(Collectors.toList());
    }
}
