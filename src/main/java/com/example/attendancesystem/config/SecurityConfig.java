package com.example.attendancesystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()

                        // Only teachers can create/modify classes, subjects, students, marks
                        .requestMatchers(HttpMethod.POST, "/classes/**", "/subjects/**", "/students/**", "/marks/**", "/attendance/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.PUT, "/classes/**", "/subjects/**", "/students/**", "/marks/**", "/attendance/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.DELETE, "/classes/**", "/subjects/**", "/students/**", "/marks/**", "/attendance/**").hasRole("TEACHER")

                        // Both roles can read (GET) — students viewing their own data, teachers viewing class data
                        .requestMatchers(HttpMethod.GET, "/**").authenticated()

                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }
}