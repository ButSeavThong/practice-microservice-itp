package com.thongfazon.account.appliactionservice.dto.create;


import lombok.Builder;

@Builder
public record CreateAccountResponse(
        String accountId,
        String accountNumber,
        String accountHolder,
        String message
) {
}
