package com.thong.account_query.domain.entity;

import com.thong.common.domain.valueobject.AccountStatus;
import com.thong.common.domain.valueobject.AccountTypeCode;
import com.thong.common.domain.valueobject.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Account {

    private UUID accountId;

    private UUID customerId;

    private UUID branchId;

    private AccountTypeCode accountTypeCode;

    private String accountNumber;

    private String accountHolder;

    private Money money;

    private AccountStatus accountStatus;

    private String createdBy;

    private String updatedBy;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @Version
    private Long version;

}