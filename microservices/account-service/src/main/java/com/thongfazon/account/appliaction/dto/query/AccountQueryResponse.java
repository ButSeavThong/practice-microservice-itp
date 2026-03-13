package com.thongfazon.account.appliaction.dto.query;

import com.thong.common.domain.valueobject.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record AccountQueryResponse(
        UUID accountId,
        String accountNumber,
        String accountHolder,
        CustomerId customerId,
        AccountTypeCode accountTypeCode,
        BranchId branchId,
        BigDecimal balance,
        Currency currency,
        AccountStatus status,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt
) {}
