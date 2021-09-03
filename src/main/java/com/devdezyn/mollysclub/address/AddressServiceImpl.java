package com.devdezyn.mollysclub.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
  private final AddressDAO addressDAO;
  
  @Autowired
  public AddressServiceImpl(AddressDAO addressDAO) {
    this.addressDAO = addressDAO;
  }

  @Override
  public List<AddressDTO> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<AddressDTO> findManyByOwner(Long ownerId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDTO createByOwner(AddressDTO addressDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDTO updateByOwner(Long ownerId, Long addressId, AddressDTO addressDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDTO deleteOneByOwner(Long ownerId, Long addressId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDTO deleteManyByOwner(Long ownerId, List<Long> addressIds) {
    // TODO Auto-generated method stub
    return null;
  }
}
