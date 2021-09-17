package com.devdezyn.mollysclub.address;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryTest {  
  @Autowired
  AddressRepository addressRepository;

  @Before
  public void setUp() throws Exception {

  }
  
  // @Test
  // public void findByDescription() throws Exception {
  //   String description = "Teaspoon";
  //   Optional<Address> uomOptional = unitOfMeasureRepository.findByDescription(description);
    
  //   assertEquals(description, uomOptional.get().getDescription());
  // }

}
