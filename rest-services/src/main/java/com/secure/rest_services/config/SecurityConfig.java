package com.secure.rest_services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/**").authenticated()
                .requestMatchers("/public/**").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService()
    {
        UserDetails admin = User.withUsername("ram")
                .password("pass")
                .authorities("admin")
                .build();
        UserDetails users = User.withUsername("Shyam")
                .password("pass")
                .authorities("user")
                .build();
        return new InMemoryUserDetailsManager(admin,users);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
