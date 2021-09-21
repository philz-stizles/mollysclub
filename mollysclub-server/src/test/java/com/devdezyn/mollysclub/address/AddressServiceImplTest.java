package com.devdezyn.mollysclub.address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AddressServiceImplTest {
  AddressServiceImpl addressService;

  @Mock
  AddressRepository addressRepository;

  @Mock
  AddressMapper addressMapper;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);

    addressService = new AddressServiceImpl(addressRepository, addressMapper);
  }

  // @Test
  // public void getAddressByIdTest() throws Exception {
  //   Address address = new Address();
  //   address.setId(1L);
  //   Optional<Address> addressOptional = Optional.of(address);

  //   when(addressRepository.findById(anyLong())).thenReturn(addressOptional);

  //   Address addressReturned = addressService.findById(1L);

  //   assertNotNull(addressReturned);
  //   verify(addressRepository, times(1)).findById(anyLong());
  //   verify(addressRepository, never()).findAll();
  // }

  // @Test(expected = NotFoundException.class)
  //   public void getAddressByIdTestNotFound() throws Exception {

  //       Optional<Address> addressOptional = Optional.empty();

  //       when(addressRepository.findById(anyLong())).thenReturn(addressOptional);

  //       Address addressReturned = addressService.findById(1L);

  //       //should go boom
  //   }

    // @Test
    // public void getAddressDtoByIdTest() throws Exception {
    //     Address address = new Address();
    //     address.setId(1L);
    //     Optional<Address> addressOptional = Optional.of(address);

    //     when(addressRepository.findById(anyLong())).thenReturn(addressOptional);

    //     AddressDto addressDto = new AddressDto();
    //     addressDto.setId(1L);

    //     when(addressMapper.convert(any())).thenReturn(addressDto);

    //     AddressDto commandById = addressService.findDtoById(1L);

    //     assertNotNull("Null address returned", commandById);
    //     verify(addressRepository, times(1)).findById(anyLong());
    //     verify(addressRepository, never()).findAll();
    // }


  @Test
  public void getAddressesTest() throws Exception {
    Address address = new Address();
    address.setId(1L);
    List<Address> mockAddressesFromRepo = new ArrayList<>();
    mockAddressesFromRepo.add(address);

    when(addressRepository.findAll()).thenReturn(mockAddressesFromRepo);

    List<AddressDto> mockAddressDtos = new ArrayList<>();
    AddressDto addressDto = new AddressDto();
    addressDto.setId(1L);

    mockAddressDtos.add(addressDto);
    when(addressMapper.toDto(any())).thenReturn(addressDto);

    List<AddressDto> addresses = addressService.findAll();

    assertEquals(addresses.size(), 1);
    verify(addressRepository, times(1)).findAll();
    verify(addressMapper, times(1)).toDto(any());
  }

  // @Test
  //   public void testDeleteById() throws Exception {

  //     //given
  //     Long idToDelete = Long.valueOf(2L);

  //     //when
  //     addressService.deleteById(idToDelete);

  //     //no 'when', since method has void return type

  //     //then
  //     verify(addressRepository, times(1)).deleteById(anyLong());
  //   }
}
