package com.rcprdn.shopbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class BasicAuthWebSecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/index.html").permitAll()
                    .anyRequest().permitAll())
            .csrf().disable()
            .httpBasic(Customizer.withDefaults());

    http.cors();

    return http.build();
  }
}
