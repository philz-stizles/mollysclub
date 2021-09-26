package com.devdezyn.mollysclub.pharmacy;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.auth.models.UserPrincipal;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService{
    private final PharmacyRepository permissionRepository;
    private final PharmacyMapper permissionMapper;


    public List<PharmacyDto> getPharmacies () {
        return permissionRepository.findAll()
        .stream().map(p -> permissionMapper.toDto(p)).collect(Collectors.toList());
    }


    @Override
    public List<PharmacyDto> getFilteredPharmacies() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public PharmacyDto getPharmacy(Long pharmacyId) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public PharmacyDto createPharmacy(UserPrincipal userPrincipal, PharmacyDto pharmacyDto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public PharmacyDto updatePharmacy(UserPrincipal userPrincipal, Long pharmacyId, PharmacyDto pharmacyDto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public PharmacyDto archivePharmacy(UserPrincipal userPrincipal, Long pharmacyId) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public AddressDto addPharmacyAddress(UserPrincipal userPrincipal, Long pharmacyId, AddressDto addressDto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public AddressDto updatePharmacyAddress(UserPrincipal userPrincipal, Long pharmacyId, Long addressId,
            AddressDto addressDto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public AddressDto deletePharmacyAddress(UserPrincipal userPrincipal, Long pharmacyId, Long addressId) {
        // TODO Auto-generated method stub
        return null;
    }
}
