package com.devdezyn.mollysclub.address;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
  private final AddressRepository addressDAO;
  private final AddressMapper addressMapper;
  
  @Autowired
  public AddressServiceImpl(AddressRepository addressDAO, AddressMapper addressMapper) {
    this.addressDAO = addressDAO;
    this.addressMapper = addressMapper;
  }

  @Override
  public List<AddressDto> findAll() {
    return addressDAO.findAll()
      .stream()
      .map(a -> addressMapper.toDto(a))
      .collect(Collectors.toList());
  }

  @Override
  public List<AddressDto> findManyByOwner(Long ownerId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDto createByOwner(AddressDto addressDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDto updateByOwner(Long ownerId, Long addressId, AddressDto addressDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDto deleteOneByOwner(Long ownerId, Long addressId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AddressDto deleteManyByOwner(Long ownerId, List<Long> addressIds) {
    // TODO Auto-generated method stub
    return null;
  }
}
