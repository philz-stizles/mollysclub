package com.devdezyn.mollysclub.pharmacy;

import java.util.List;

import com.devdezyn.mollysclub.address.AddressDto;
import com.devdezyn.mollysclub.auth.models.UserPrincipal;

public interface  PharmacyService {

    public List<PharmacyDto> getPharmacies();

    public List<PharmacyDto> getFilteredPharmacies();

    public PharmacyDto getPharmacy(Long pharmacyId);

    public PharmacyDto createPharmacy(UserPrincipal userPrincipal, PharmacyDto pharmacyDto);

    public PharmacyDto updatePharmacy(UserPrincipal userPrincipal, Long pharmacyId, PharmacyDto pharmacyDto);
    
    public PharmacyDto archivePharmacy(UserPrincipal userPrincipal, Long pharmacyId);
    
    public AddressDto addPharmacyAddress(UserPrincipal userPrincipal, Long pharmacyId, AddressDto addressDto);

    public AddressDto updatePharmacyAddress(UserPrincipal userPrincipal, Long pharmacyId, Long addressId,
            AddressDto addressDto);

    public AddressDto deletePharmacyAddress(UserPrincipal userPrincipal, Long pharmacyId, Long addressId);
}
