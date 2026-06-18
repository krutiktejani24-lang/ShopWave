package com.shopwave.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .cors(cors -> {})
        .formLogin(form -> form.disable())
        .httpBasic(httpBasic -> httpBasic.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/",
                "/products/**",
                "/api/products/**",
                "/login",
                "/register"
            ).permitAll()
            .anyRequest().authenticated()
        );

    http.addFilterBefore(
            jwtFilter,
            UsernamePasswordAuthenticationFilter.class
    );

    return http.build();
}
}