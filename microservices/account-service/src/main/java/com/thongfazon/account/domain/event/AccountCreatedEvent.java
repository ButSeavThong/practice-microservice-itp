package com.thongfazon.account.domain.event;

import com.thong.common.domain.valueobject.*;
import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record AccountCreatedEvent(
        AccountId accountId,
        String accountNumber,
        String accountHolder,
        CustomerId customerId,
        AccountTypeCode accountTypeCode,
        BranchId branchId,
        Money initialBalance,
        ZonedDateTime createdAt,
        String createdBy,
        AccountStatus status
) {
}
