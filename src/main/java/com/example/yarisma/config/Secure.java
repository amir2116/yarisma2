package com.example.yarisma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class Secure {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
                User.builder().username("admin").password(encoder.encode("tgtcin123")).roles("ADMIN").build(),
                User.builder().username("user").password(encoder.encode("salamuser")).roles("USER").build(),
                User.builder().username("team1").password(encoder.encode("team1")).roles("TEAM1").build(),
                User.builder().username("team2").password(encoder.encode("team2")).roles("TEAM2").build(),
                User.builder().username("team3").password(encoder.encode("team3")).roles("TEAM3").build(),
                User.builder().username("team4").password(encoder.encode("team4")).roles("TEAM4").build(),
                User.builder().username("team5").password(encoder.encode("team5")).roles("TEAM5").build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/ws/**", "/buzzer", "/buzzer/**", "/buzzer*", "/buzzer*/*").permitAll() // allow WebSocket handshakes
                        .requestMatchers("/screen/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/button/**").hasAnyRole("TEAM1", "TEAM2", "TEAM3", "TEAM4", "TEAM5")
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {})
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173","http://localhost:5174","http://localhost:5175","http://192.168.1.81:5173/"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
