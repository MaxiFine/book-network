package com.alibou.book.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.alibou.book.roleperms.Role;

import static com.alibou.book.roleperms.Permissions.*;
import static com.alibou.book.roleperms.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)  // this way to secure using annotations
public class SecurityConfig {
    /**
     * This will hold the configurations of our application
     * */
    private final JwtFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)  // disables crsf
                .authorizeHttpRequests(req ->
                        req.requestMatchers(
                                "/auth/**",
                                "/api/v2/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-resources",
                                "/swagger-resources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-ui.html"
                        ).permitAll()
//                                // securing the endpoints using permissions
//                                .requestMatchers("/api/v1/api/v1/manager/**").hasAnyRole(ADMIN.name(), MANAGER.name(), USER.name())
//                                // SECURING OPERATION PERMISSIONS FOR ADMIN
//                                .requestMatchers("/api/v1/api/v1/admin/**").hasRole(ADMIN.name())
//
//                                .requestMatchers(GET, "/api/v1/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
//                                .requestMatchers(POST, "/api/v1/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
//                                .requestMatchers(PUT, "/api/v1/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
//                                .requestMatchers(DELETE, "/api/v1/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())
//
//                                // SECURING OPERATION PERMISSIONS FOR MANAGER
//                                .requestMatchers(GET, "/api/v1/api/v1/manager/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
//                                .requestMatchers(POST, "/api/v1/api/v1/manager/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
//                                .requestMatchers(PUT, "/api/v1/api/v1/manager/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
//                                .requestMatchers(DELETE, "/api/v1/api/v1/manager/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
//
//                                // SECURING OPERATION PERMISSIONS FOR MANAGER
//                                .requestMatchers(GET, "/api/v1/api/v1/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name(), USER.name())
//                                .requestMatchers(POST, "/api/v1/api/v1/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name(), USER.name())
//                                .requestMatchers(PUT, "/api/v1/api/v1/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name(), USER.name())
//                                .requestMatchers(DELETE, "/api/v1/api/v1/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name(), USER.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
