package com.devdezyn.mollysclub.address;

import java.util.List;

import com.devdezyn.mollysclub.shared.payloads.PagedResponse;

public interface AddressService {
  List<AddressDto> findAll();

  PagedResponse<AddressDto> findFiltered(int page, int size);

  AddressDto findById(Long id);
}
