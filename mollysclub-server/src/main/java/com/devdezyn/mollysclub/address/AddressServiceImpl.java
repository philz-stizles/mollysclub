package com.devdezyn.mollysclub.address;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.devdezyn.mollysclub.shared.exceptions.BadRequestException;
import com.devdezyn.mollysclub.shared.payloads.PagedResponse;
import com.devdezyn.mollysclub.shared.utils.AppConstants;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
  private final AddressRepository addressRepository;
  private final AddressMapper addressMapper;
  // private final UserService userService;
  // private IAuthenticationFacade authenticationFacade;

  @Override
  public List<AddressDto> findAll() {
    return addressRepository.findAll()
      .stream()
      .map(a -> addressMapper.toDto(a))
      .collect(Collectors.toList());
  }

  @Override
  public PagedResponse<AddressDto> findFiltered(int page, int size) {
    validatePageNumberAndSize(page, size);

    // Retrieve Addresses.
    Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
    Page<Address> addressesPage = addressRepository.findAll(pageable);

    if (addressesPage.getNumberOfElements() <= 0) {
      return new PagedResponse<>(Collections.emptyList(), addressesPage.getNumber(), addressesPage.getSize(),
          addressesPage.getTotalElements(), addressesPage.getTotalPages(), addressesPage.isLast());
    }
    
    var addressesDtoPage = addressesPage.stream().map(a -> addressMapper.toDto(a)).collect(Collectors.toList());

    return new PagedResponse<>(addressesDtoPage, addressesPage.getNumber(),
                addressesPage.getSize(), addressesPage.getTotalElements(), addressesPage.getTotalPages(), addressesPage.isLast());
  }

  @Override
  public AddressDto findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
