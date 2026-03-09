package com.thongfazon.account.appliaction.dto.query;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.AccountStatus;
import com.thong.common.domain.valueobject.AccountTypeCode;
import com.thongfazon.account.domain.valueobject.BranchId;
import com.thongfazon.account.domain.valueobject.Currency;
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
