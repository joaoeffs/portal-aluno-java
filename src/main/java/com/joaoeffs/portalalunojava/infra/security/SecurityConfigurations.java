package com.joaoeffs.portalalunojava.infra.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://portalalunoapp.s3-website-sa-east-1.amazonaws.com"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://portalalunoapp.s3-website-sa-east-1.amazonaws.com")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/api/auth").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/usuario").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/usuario").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/disciplina").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/disciplina").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.POST, "/api/alunodisciplina").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.POST, "/api/notas").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.PUT, "/api/notas").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.GET, "/api/notas").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.GET, "/api/notas/aluno/{alunoId}").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/api/disciplina").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.DELETE, "/api/alunodisciplina").hasRole("PROFESSOR")
                .requestMatchers(HttpMethod.GET, "/api/alunodisciplina").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/alunodisciplina/{id}/aluno").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
