package com.devdezyn.mollysclub.auth.security;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Slf4j
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        log.error("Responding with unauthorized error. Message - {}", e.getMessage());

        //Create data object
        HashMap<String, Object> error = new HashMap<>(3);
        error.put("uri", request.getRequestURI());
        error.put("error", e.getMessage());
        
        //Create response body as Map
        HashMap<String, Object> responseBody = new HashMap<>(3);
        responseBody.put("message", "Unauthorized access");
         responseBody.put("data", error);
         responseBody.put("status", false);
        
         // Convert Map to JSON/String
         ObjectMapper objectMapper = new ObjectMapper();
         String resBody = objectMapper.writeValueAsString(responseBody);
         
         // Build response
         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         response.setCharacterEncoding("utf-8");
         response.setContentType(MediaType.APPLICATION_JSON_VALUE);
         
         // Open response 
         PrintWriter printWriter = response.getWriter();
         printWriter.print(resBody);
         printWriter.flush();
         printWriter.close();
        // httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
