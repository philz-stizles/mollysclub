package com.devdezyn.mollysclub.address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class AddressControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddressService addressService;

    @Test
    public void getAddressesTest()
    throws Exception {
        
        AddressDto address1 = new AddressDto();
        address1.setId(1L);
        address1.setZip("101112");
        address1.setStreet("Oyadiran");
        address1.setCity("Yaba");
        address1.setState("Lagos");
        address1.setCountry("Nigeria");


        List<AddressDto> allAddresses = Arrays.asList(address1);

        when(addressService.findAll()).thenReturn(allAddresses);

        mvc.perform(get("/api/v1/addresses")
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
            // .andExpect(jsonPath("$", size(1)))
            // .andExpect(jsonPath("$[0].zip", eq(address1.getZip())));
    }
}
