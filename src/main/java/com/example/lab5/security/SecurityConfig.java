package com.example.lab5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(httpRequests->{
            httpRequests.requestMatchers("/auth/register").permitAll().anyRequest().authenticated();
        });
        http.formLogin(httpSecurityFormLoginConfigurer -> {
            try {
                httpSecurityFormLoginConfigurer.defaultSuccessUrl("/swagger-ui/index.html",true).init(http);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        http.logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.init(http));

        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
