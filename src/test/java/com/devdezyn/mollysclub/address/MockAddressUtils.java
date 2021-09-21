package com.devdezyn.mollysclub.address;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MockAddressUtils {

  public static Address getMockAddress() {
    Address user = new Address();
    
    return user;
  }
    
  public static AddressDto getMockAddressDto() {
       AddressDto user = new AddressDto();
        return user;
    }
}
