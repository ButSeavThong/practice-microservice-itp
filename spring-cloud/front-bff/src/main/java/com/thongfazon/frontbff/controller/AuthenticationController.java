package com.thongfazon.frontbff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);


    @GetMapping("/me")
    public com.thongfazon.frontbff.dto.ProfileResponse me(@AuthenticationPrincipal OidcUser oidcUser) {

        log.info("OIDC USER : {}", oidcUser);
//        log.info("USER INFO : {}", oidcUser.getUserInfo());
//        log.info("FAMILY NAME : {}", oidcUser.getUserInfo().getFamilyName());

        List<String> rolesList = oidcUser.getAttribute("roles");
        Set<String> roles = rolesList != null ? new HashSet<>(rolesList) : new HashSet<>();

        List<String> permissionsList = oidcUser.getAttribute("permissions");
        Set<String> permissions = permissionsList != null ? new HashSet<>(permissionsList) : new HashSet<>();

        return com.thongfazon.frontbff.dto.ProfileResponse.builder()
                .username(oidcUser.getName())
                .email(oidcUser.getEmail())
                .familyName(oidcUser.getFamilyName())
                .givenName(oidcUser.getGivenName())
                .phoneNumber(oidcUser.getPhoneNumber())
                .gender(oidcUser.getGender())
                .birthdate(oidcUser.getBirthdate())
                .picture(oidcUser.getPicture())
                .coverImage(oidcUser.getAttribute("cover_image"))
                .roles(roles)
                .permission(permissions)
                .build();
    }

}