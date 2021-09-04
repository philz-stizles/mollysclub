package com.devdezyn.mollysclub.address;

import java.util.List;

public interface AddressService {
  List<AddressDTO> findAll();
  List<AddressDTO> findManyByOwner(Long ownerId);
  AddressDTO createByOwner(AddressDTO addressDTO);

  AddressDTO updateByOwner(Long ownerId, Long addressId, AddressDTO addressDTO);

  AddressDTO deleteOneByOwner(Long ownerId, Long addressId);
  AddressDTO deleteManyByOwner(Long ownerId, List<Long> addressIds);
}
