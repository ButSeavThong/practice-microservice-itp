package com.thongfazon.account.domain.entity;

import com.thong.common.domain.valueobject.AccountStatus;
import com.thong.common.domain.valueobject.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class Account {
    private UUID accountId;
    private String accountNumber;
    private String accountHolder;
    private UUID customerId;
    private String accountTypeCode;
    private UUID branchId;
    private BigDecimal balance;
    private Currency currency;
    private AccountStatus status;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
