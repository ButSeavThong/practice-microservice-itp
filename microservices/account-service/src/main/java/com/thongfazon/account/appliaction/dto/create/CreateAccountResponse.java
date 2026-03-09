package com.thongfazon.account.appliaction.dto.create;


import lombok.Builder;

@Builder
public record CreateAccountResponse(
        String accountId,
        String accountNumber,
        String accountHolder,
        String message
) {
}
