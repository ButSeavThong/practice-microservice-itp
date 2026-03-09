package com.thong.pipeline.client.dto;

public record UserResponse(
        Long id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}
