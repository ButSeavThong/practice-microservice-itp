package com.thong.pipeline.client.dto;

public record PipelineUserAccountResponse(
        Long userId,
        String name,
        String email,
        String accountNo,
        Double balance
) {}
