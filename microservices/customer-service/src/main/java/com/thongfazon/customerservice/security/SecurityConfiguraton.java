package com.thongfazon.customerservice.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguraton {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            // all request have to authenticated
            http.authorizeHttpRequests(auth->auth.anyRequest().permitAll());
            http.csrf(token->token.disable());
            http.httpBasic(basic->basic.disable());
            http.formLogin(form->form.disable());
            http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            http.oauth2ResourceServer(auth2->auth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
}
