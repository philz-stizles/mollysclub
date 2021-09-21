package com.devdezyn.mollysclub.address;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.devdezyn.mollysclub.AbstractTest;
import com.devdezyn.mollysclub.WithMockCustomUser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;

// To test Spring MVC controllers are working as expected you can use the @WebMvcTest annotation. @WebMvcTest will auto-configure the Spring MVC infrastructure and limit scanned beans to @Controller, @ControllerAdvice, @JsonComponent, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver. Regular @Component beans will not be scanned when using this annotation.

// Often @WebMvcTest will be limited to a single controller and used in combination with @MockBean to provide mock implementations for required collaborators.

// @WebMvcTest also auto-configures MockMvc. Mock MVC offers a powerful way to quickly test MVC controllers without needing to start a full HTTP server.

// [Tip]
// You can also auto-configure MockMvc in a non-@WebMvcTest (e.g. SpringBootTest) by annotating it with @AutoConfigureMockMvc.

@WebMvcTest(controllers = AddressController.class)
@WithMockCustomUser
public class AddressControllerIT extends AbstractTest {
  @Autowired
  private WebApplicationContext context;
  
  @MockBean
  private AddressService addressService;

  // @Before
	// public void setup() {
	// 	mockMvc = MockMvcBuilders
	// 			.webAppContextSetup(context)
	// 			.apply(springSecurity()) 
	// 			.build();
	// }

  @Test
  public void getAddresses() throws Exception {

    AddressDto address = new AddressDto();
    address.setId(1L);

    List<AddressDto> mockDtosFromService = new ArrayList<>();
    mockDtosFromService.add(address);

    when(addressService.findAll()).thenReturn(mockDtosFromService);

    mockMvc.perform(get("/api/v1/addresses").contentType(MediaType.APPLICATION_JSON))
      // .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", notNullValue()))
      .andExpect(jsonPath("$.status", is(true)))
      .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data", hasSize(1)));
        // .andExpect(jsonPath("$.errors", hasItem("Please provide a author")))
      
    verify(addressService, times(1)).findAll();
      // verify(mockRepository, times(0)).save(any(Book.class));
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
