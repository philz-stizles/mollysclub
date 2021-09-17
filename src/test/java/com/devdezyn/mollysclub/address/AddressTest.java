package com.devdezyn.mollysclub.address;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
  Address address;

  @Before
  public void setUp() {
    address = new Address();
  }

  @Test
  public void getId() throws Exception {
    Long id = 4L;
    address.setId(id);

    assertEquals(id, address.getId());
  }
}
