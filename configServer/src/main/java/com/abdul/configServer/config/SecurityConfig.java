package com.abdul.configServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/actuator/**"))
                .authorizeHttpRequests(authorize -> authorize.anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults());  // Enable basic authentication with updated syntax
        return http.build();
    }
}
