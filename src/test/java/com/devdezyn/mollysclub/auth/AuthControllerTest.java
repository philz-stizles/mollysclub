package com.devdezyn.mollysclub.auth;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devdezyn.mollysclub.auth.registration.RegistrationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AuthControllerTest {
  @Mock
  private RegistrationService registrationService;

  @InjectMocks
  private AuthController authController;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    mockMvc = MockMvcBuilders.standaloneSetup(authController)
        // .setControllerAdvice(new ControllerExceptionHandler())
        .build();
  }
  
  @Test
	public void contextLoads() throws Exception {
      assertNotNull(authController);
	}
}
