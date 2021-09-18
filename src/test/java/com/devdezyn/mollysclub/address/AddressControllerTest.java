package com.devdezyn.mollysclub.address;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.devdezyn.mollysclub.WithMockCustomUser;
import com.devdezyn.mollysclub.auth.services.JwtTokenService;
import com.devdezyn.mollysclub.user.UserService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// To test Spring MVC controllers are working as expected you can use the @WebMvcTest annotation. @WebMvcTest will auto-configure the Spring MVC infrastructure and limit scanned beans to @Controller, @ControllerAdvice, @JsonComponent, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver. Regular @Component beans will not be scanned when using this annotation.

// Often @WebMvcTest will be limited to a single controller and used in combination with @MockBean to provide mock implementations for required collaborators.

// @WebMvcTest also auto-configures MockMvc. Mock MVC offers a powerful way to quickly test MVC controllers without needing to start a full HTTP server.

// [Tip]
// You can also auto-configure MockMvc in a non-@WebMvcTest (e.g. SpringBootTest) by annotating it with @AutoConfigureMockMvc.

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = SecurityConfig.class)
// @WithMockCustomUser
@WebMvcTest(controllers = AddressController.class)
// @Import(SecuredControllerTest.Config.class)
public class AddressControllerTest {
  // @Autowired
  private AddressController addressController;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  BCryptPasswordEncoder passwordEncoder;

  @MockBean
  AuthenticationEntryPoint authenticationEntryPoint;

  @MockBean
  AddressService addressService;

  @MockBean
  UserService userService;

  @MockBean
  JwtTokenService jwtTokenService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);
    
    addressController = new AddressController(addressService);
    mockMvc = MockMvcBuilders.standaloneSetup(addressController)
      // .setControllerAdvice(new ControllerExceptionHandler())
      .build();
  }

  // @WithMockCustomUser
  @Test
  public void getAddress() throws Exception {

    AddressDto address = new AddressDto();
    address.setId(1L);

    List<AddressDto> mockAddressDtosFromRepo = new ArrayList<>();
    mockAddressDtosFromRepo.add(address);

    when(addressService.findAll()).thenReturn(mockAddressDtosFromRepo);

    mockMvc.perform(get("/api/v1/addresses")).andExpect(status().isOk());
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
