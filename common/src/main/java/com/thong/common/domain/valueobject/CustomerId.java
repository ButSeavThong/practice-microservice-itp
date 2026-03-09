package com.thong.common.domain.valueobject;


import java.util.UUID;

public record CustomerId(
        UUID value
) {
    @Override
    public String toString() {
        return value.toString();
    }
}


