package com.security.security_app.config;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.security.security_app.security.JwtAuthenticationEntryPoint;
import com.security.security_app.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    private UserDetailsService userDetailsService;
    private JwtAuthenticationFilter authenticationFilter;
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationFilter authenticationFilter, JwtAuthenticationEntryPoint authenticationEntryPoint) {
        super();
        this.userDetailsService = userDetailsService;
        this.authenticationFilter = authenticationFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http.csrf(csrf -> csrf.disable()).cors(withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));

        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/login", "/api/register").permitAll()
                .requestMatchers("/studentapp/**").authenticated().anyRequest().authenticated());

        http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
