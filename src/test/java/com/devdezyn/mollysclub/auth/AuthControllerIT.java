package com.devdezyn.mollysclub.auth;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.devdezyn.mollysclub.AbstractTest;
import com.devdezyn.mollysclub.auth.dtos.LoginDto;
import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterResponse;
import com.devdezyn.mollysclub.auth.services.RegistrationService;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@WebMvcTest(controllers = AuthController.class)
// @RunWith(SpringRunner.class)
// @SpringBootTest
// @AutoConfigureMockMvc
public class AuthControllerIT extends AbstractTest {
  private final String BASE_URI = "/api/v1/auth";

    @MockBean
    private RegistrationService registerService;
  
    @TestConfiguration
    static class TestContextConfiguration {
      @Bean
      public MethodValidationPostProcessor bean() {
        return new MethodValidationPostProcessor();
      }
    }

	@Test
    public void register_fails_with_bad_email() throws Exception {
      RegisterRequest registerRequest = RegisterRequest.builder()
          .username("mockUsername")
          .password("mockPassword")
          .build();

      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(BASE_URI + "/register")
          .content(mapToJson(registerRequest))
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);

      mockMvc.perform(mockRequest)
          // .andDo(print())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$.status", is(false)))
        .andExpect(jsonPath("$.errors").isArray())
        .andExpect(jsonPath("$.errors[0]", containsString("email")));
    }

    @Test
    public void register_fails_with_bad_username() throws Exception {
      RegisterRequest registerRequest = RegisterRequest.builder().email("mockUser@email.test").password("mockPassword")
          .build();

      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(BASE_URI + "/register")
          .content(mapToJson(registerRequest))
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);

      mockMvc.perform(mockRequest).andExpect(status().isBadRequest()).andExpect(jsonPath("$", notNullValue()))
          .andExpect(jsonPath("$.status", is(false))).andExpect(jsonPath("$.errors").isArray())
          .andExpect(jsonPath("$.errors[0]", containsString("username")));
    }
    
    @Test
    public void register_fails_with_bad_password() throws Exception {
      RegisterRequest registerRequest = RegisterRequest.builder()
          .username("mockUsername")
          .email("mockUser@email.test")
          .build();

      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(BASE_URI + "/register")
          .content(mapToJson(registerRequest))
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);

      mockMvc.perform(mockRequest).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andExpect(jsonPath("$", notNullValue()))
          .andExpect(jsonPath("$.status", is(false)))
          .andExpect(jsonPath("$.errors").isArray())
          .andExpect(jsonPath("$.errors[0]", containsString("password")));
    }
    
    @Test
    public void register_success_with_valid_credentials() throws Exception {
      RegisterRequest registerRequest = RegisterRequest.builder().username("mockUsername").email("mockUser@email.test")
          .password("mockPassword").build();

      RegisterResponse registerResponse = RegisterResponse.builder().username("mockUsername")
          .email("mockUser@email.test").build();

      Mockito.when(registerService.createUser(any(RegisterRequest.class))).thenReturn(registerResponse);

      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(BASE_URI + "/register")
          .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
          .content(mapToJson(registerRequest));

      mockMvc.perform(mockRequest).andExpect(status().isCreated()).andExpect(jsonPath("$", notNullValue()))
              .andExpect(jsonPath("$.status", is(true)));
          
        ArgumentCaptor<RegisterRequest> userCaptor = ArgumentCaptor.forClass(RegisterRequest.class);
        verify(registerService, times(1)).createUser(userCaptor.capture());
        assertThat(userCaptor.getValue().getUsername(), equalTo("mockUsername"));
        assertThat(userCaptor.getValue().getEmail(), equalTo("mockUser@email.test"));
    }
    
    @Test
    public void login_fails_with_bad_username() throws Exception {
      LoginDto loginDto = LoginDto.builder().password("mockPassword").build();

      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(BASE_URI + "/login")
          .content(mapToJson(loginDto))
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);

      mockMvc.perform(mockRequest).andExpect(status().isBadRequest()).andExpect(jsonPath("$", notNullValue()))
          .andExpect(jsonPath("$.status", is(false))).andExpect(jsonPath("$.errors").isArray())
          .andExpect(jsonPath("$.errors[0]", containsString("usernameOrEmail")));
    }
    
    @Test
    public void login_fails_with_bad_password() throws Exception {
      LoginDto loginDto = LoginDto.builder()
          .usernameOrEmail("mockUsername")
          .build();

      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(BASE_URI + "/login")
          .content(mapToJson(loginDto))
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);

      mockMvc.perform(mockRequest).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andExpect(jsonPath("$", notNullValue()))
          .andExpect(jsonPath("$.status", is(false)))
          .andExpect(jsonPath("$.errors").isArray())
          .andExpect(jsonPath("$.errors[0]", containsString("password")));
    }
}
