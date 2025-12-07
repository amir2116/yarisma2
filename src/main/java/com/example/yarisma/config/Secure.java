package com.example.yarisma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class Secure {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.builder().username("admin").password("tgtcin123").roles("ADMIN").build();
        UserDetails user2 = User.builder().username("user").password("salamuser").roles("USER").build();
        UserDetails button1 = User.builder().username("button1").password("button1").roles("BUTTON1").build();
        UserDetails button2 = User.builder().username("button2").password("button2").roles("BUTTON2").build();
        UserDetails button3 = User.builder().username("button3").password("button3").roles("BUTTON3").build();
        UserDetails button4 = User.builder().username("button4").password("button4").roles("BUTTON4").build();
        return new InMemoryUserDetailsManager(user, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/button/**").hasAnyRole("BUTTON1", "BUTTON2", "BUTTON3", "BUTTON4")
                        .requestMatchers("/screen/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());

        return http.build();
    }

}
