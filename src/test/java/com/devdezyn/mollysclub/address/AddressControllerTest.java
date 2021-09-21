package com.devdezyn.mollysclub.address;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import java.util.ArrayList;
import java.util.List;

import com.devdezyn.mollysclub.AbstractTest;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = AddressController.class)
// @WithMockCustomUser
public class AddressControllerTest extends AbstractTest {
  @Autowired
  private WebApplicationContext context;
  
  @MockBean
  private AddressService addressService;

  
  @Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity()) 
				.build();
	}

  @Test
  public void getAddresses() throws Exception {

    AddressDto address = new AddressDto();
    address.setId(1L);

    List<AddressDto> mockDtosFromService = new ArrayList<>();
    mockDtosFromService.add(address);

    when(addressService.findAll()).thenReturn(mockDtosFromService);

    // when
    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/addresses")
        .accept(MediaType.APPLICATION_JSON)
    ).andReturn().getResponse();

    // then
    assertEquals(response.getStatus(), HttpStatus.OK.value());
    // assertEquals(response.getContentAsString(),
    //        mapToJson(mockDtosFromService)
    // );
  }

  // @Test @WithAnonymousUser
  // public void test3() throws Exception {
  //     // Details omitted for brevity
  // }

  // @Configuration
  // @EnableWebSecurity
  // static class Config extends MyWebSecurityConfigurerAdapter {
  //   @Autowired
  //   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  //     auth.inMemoryAuthentication().withUser("user").password("pa$$").roles("USER");
  //     auth.inMemoryAuthentication().withUser("admin").password("pa$$").roles("ADMIN");
  //   }
  // }
}
