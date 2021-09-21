package com.devdezyn.mollysclub;

import java.io.IOException;

import com.devdezyn.mollysclub.auth.services.JwtTokenService;
import com.devdezyn.mollysclub.user.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
public abstract class AbstractTest {
   @Autowired
   private ObjectMapper objectMapper;
  
   @MockBean
   protected BCryptPasswordEncoder passwordEncoder;

   @MockBean
   protected AuthenticationEntryPoint authenticationEntryPoint;

    @MockBean
    protected UserService userService;

    @MockBean
    protected JwtTokenService jwtTokenProvider;

     @Autowired
  protected MockMvc mockMvc;
   
   // @Autowired
   // WebApplicationContext webApplicationContext;

   // protected void setUp() {
   //    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   // }

   protected String mapToJson(Object obj) throws JsonProcessingException {
      return objectMapper.writeValueAsString(obj);
   }

   protected <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
      
      return objectMapper.readValue(json, clazz);
   }
}
