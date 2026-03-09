package com.thongfazon.frontbff.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {
    @GetMapping("/oauth2/authenticated/me")
    public Mono<OAuth2User> me(@AuthenticationPrincipal OAuth2User user) {
        return Mono.just(user);
    }
}
