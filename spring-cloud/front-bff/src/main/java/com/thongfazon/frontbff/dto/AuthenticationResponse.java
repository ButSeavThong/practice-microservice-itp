package com.thongfazon.frontbff.dto;


import lombok.Builder;

@Builder
public record AuthenticationResponse(
        Boolean isAuthenticated,
        String username
) {
}