// package com.devdezyn.mollysclub.address;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import org.junit.Before;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// public class AddressControllerTest {

//     AddressController addressController;

//     @Mock
//     AddressService addressService;

//     @Before
//     public void setUp() throws Exception {
//         MockitoAnnotations.openMocks(this);

//         addressController = new AddressController(addressService);
//     }

//     @Test
//     public void testGetAddress() throws Exception {
//         MockMvc mockMvc = MockMvcBuilders.standaloneSetup(addressController).build();
//         mockMvc.perform(get("/api/v1/addresses"))
//                 .andExpect(status().isOk());
//         }
// }
