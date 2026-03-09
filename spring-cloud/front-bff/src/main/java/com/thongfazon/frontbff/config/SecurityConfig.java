package com.thongfazon.frontbff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.net.URI;
import java.util.Arrays;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain webSecurity(
            ServerHttpSecurity http,
            ReactiveClientRegistrationRepository clientRegistrationRepository
    ) {
        http.authorizeExchange(exchange -> exchange
                // Public endpoints (no authentication required)
                .pathMatchers(
                        "/",
                        "/_next/**",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/webjars/**",
                        "/favicon.ico",
                        "/oauth2/**",
                        "/public/**",
                        "/login/**",
                        "/oauth2/authenticated/me"  // Allow checking auth status
                ).permitAll()

                // Protected endpoints (require authentication)
                .pathMatchers(
                        "/profile/**",
                        "/auth/profile"  // Profile endpoint requires authentication
                ).authenticated()

                // All other endpoints are permitted by default
                .anyExchange().permitAll()
        );

        // CORS configuration for Next.js frontend
        http.cors(cors -> cors.disable());

        // Disable CSRF (BFF handles this differently with same-site cookies)
        http.csrf(csrfSpec -> csrfSpec.disable());

        // Disable form login (using OAuth2 login instead)
        http.formLogin(formLoginSpec -> formLoginSpec.disable());

        // Disable HTTP Basic (using OAuth2 login instead)
        http.httpBasic(httpBasicSpec -> httpBasicSpec.disable());

        // Enable OAuth2 Login with custom success handler
        http.oauth2Login(oauth2 -> oauth2
                .authenticationSuccessHandler(authenticationSuccessHandler())
        );

        // Configure OIDC Logout (logs out from Authorization Server)
        http.logout(logoutSpec -> logoutSpec
                .logoutSuccessHandler(oidcLogoutSuccessHandler(clientRegistrationRepository))
        );

        return http.build();
    }

    /**
     * Custom authentication success handler
     * Redirects to Next.js frontend after successful OAuth2 login
     */
    @Bean
    public RedirectServerAuthenticationSuccessHandler authenticationSuccessHandler() {
        RedirectServerAuthenticationSuccessHandler successHandler =
                new RedirectServerAuthenticationSuccessHandler();

        // Redirect to BFF base URL (which proxies to Next.js)
        successHandler.setLocation(URI.create("/"));  // Relative URL

        return successHandler;
    }

    private ServerLogoutSuccessHandler oidcLogoutSuccessHandler(
            ReactiveClientRegistrationRepository clientRegistrationRepository
    ) {
        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository);

        // Redirect to BFF base URL after logout
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}");

        return oidcLogoutSuccessHandler;
    }

}