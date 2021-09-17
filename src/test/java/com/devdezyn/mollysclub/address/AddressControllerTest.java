// package com.devdezyn.mollysclub.address;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import org.junit.Before;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// @RunWith(SpringJUnit4ClassRunner.class)
// @WithMockUser
// public class AddressControllerTest {
//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     AddressService addressService;

//     // @Before
//     // public void setUp() throws Exception {
//     //     MockitoAnnotations.openMocks(this);

//     //     addressController = new AddressController(addressService);
//     // }

//     @Test
//     @WithMockUser(username="admin",roles={"USER","ADMIN"})
//     public void testGetAddress() throws Exception {
//         this.mockMvc.perform(get("/api/v1/addresses"))
//                 .andExpect(status().isOk());
//         }
// }
