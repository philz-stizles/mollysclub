package com.devdezyn.mollysclub.address;

import java.util.List;

public interface AddressService {
  List<AddressDto> findAll();
  List<AddressDto> findManyByOwner(Long ownerId);
  AddressDto createByOwner(AddressDto addressDTO);

  AddressDto updateByOwner(Long ownerId, Long addressId, AddressDto addressDTO);

  AddressDto deleteOneByOwner(Long ownerId, Long addressId);
  AddressDto deleteManyByOwner(Long ownerId, List<Long> addressIds);
}
