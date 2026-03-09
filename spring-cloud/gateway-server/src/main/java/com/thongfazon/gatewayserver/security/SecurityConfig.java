package com.thongfazon.gatewayserver.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain webSecurity(ServerHttpSecurity http) {
        http.authorizeExchange(exchange -> exchange
//                pathMatchers("/account/public/**", "/actuator/**").permitAll()
                .anyExchange().permitAll()
                );

        // disable all security feature on gateway and let Authorization server handle it
        http.csrf(csrfSpec -> csrfSpec.disable());
        http.formLogin(formLoginSpec -> formLoginSpec.disable());
        http.logout(logoutSpec -> logoutSpec.disable());
        http.httpBasic(httpBasicSpec -> httpBasicSpec.disable());


        // use authorization of authorization server
//        http.oauth2Login(Customizer.withDefaults());

        http.oauth2ResourceServer(oauth2-> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }


    /**
     * Logout success handler - redirects to frontend after logout
     */
//    @Bean
//    public ServerLogoutSuccessHandler logoutSuccessHandler() {
//        RedirectServerLogoutSuccessHandler handler = new RedirectServerLogoutSuccessHandler();
//        handler.setLogoutSuccessUrl(URI.create("http://localhost:3000"));
//        return handler;
//    }
}
