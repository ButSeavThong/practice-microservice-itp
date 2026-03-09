package com.thong.common.domain.application.exception;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record ErrorResponse(
        String stats,
        Integer code,
        String message,
        ZonedDateTime timestamp
) {
}
