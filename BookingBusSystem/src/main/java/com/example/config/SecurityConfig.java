package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
  @Bean
  public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
    jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
    return jwtAuthenticationTokenFilter;
  }
  @Bean
  public RestAuthenticationEntryPoint restServicesEntryPoint() {
    return new RestAuthenticationEntryPoint();
  }
  @Bean
  public CustomAccessDeniedHandler customAccessDeniedHandler() {
    return new CustomAccessDeniedHandler();
  }
  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }
  protected void configure(HttpSecurity http) throws Exception {
    // Disable crsf cho đường dẫn /rest/**
    http.csrf().ignoringAntMatchers("/**");
  
//    http.authorizeRequests().antMatchers("/findbyEmail**").permitAll();
    http.authorizeRequests().antMatchers("/**").permitAll();
    
    
    
    http.antMatcher("/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CUSTOMER')  or hasRole('ROLE_TICKET_SELLER')")
        .antMatchers(HttpMethod.POST, "/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CUSTOMER')  or hasRole('ROLE_TICKET_SELLER')")
        .antMatchers(HttpMethod.PUT, "/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CUSTOMER')  or hasRole('ROLE_TICKET_SELLER')")
        .antMatchers(HttpMethod.DELETE, "/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CUSTOMER')  or hasRole('ROLE_TICKET_SELLER')").and()
        .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
  }
}
