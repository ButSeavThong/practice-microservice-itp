package com.thong.pipeline.client.dto;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {
}
