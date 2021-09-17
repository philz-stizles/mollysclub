package com.devdezyn.mollysclub.auth.security;

import com.devdezyn.mollysclub.auth.token.JwtTokenProvider;
import com.devdezyn.mollysclub.user.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// @EnableGlobalMethodSecurity(
//     securedEnabled = true,
//     jsr250Enabled = true,
//     prePostEnabled = true
// )
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
        "/jacoco/index.html",
        "/login",
            "/api/v*/users/**",
            "/api/v*/auth/**",
            "/h2-console/**",
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
//    private final JwtConfig jwtConfig;
//     private final SecretKey secretKey; 

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                this.authenticationManager(), jwtTokenProvider);
        
        // Override default login url.
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/auth/login");

        // Enable CORS
        http = http.cors().and();

        // disable CSRF
        http = http.csrf().disable();

        // Set session management to stateless
        http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        // Set unauthorized requests exception handler
        // http = http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint
        // // (request, response, ex) -> {
        // //     response.sendError(
        // //         HttpServletResponse.SC_UNAUTHORIZED,
        // //         ex.getMessage()
        // //     );
        // // }
        // ).and();

        //Set permissions on endpoints
        http = http.authorizeRequests()
        .antMatchers(AUTH_WHITELIST).permitAll()
                // .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                // .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                // .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                // .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name())
                .anyRequest().authenticated().and().headers().frameOptions().sameOrigin().and();
        
        //Add Authentication filter.
        http.addFilter(customAuthenticationFilter);

        //Add Authorization filter.
        http.addFilterBefore(new CustomAuthorizationFilter(jwtTokenProvider, userService), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

