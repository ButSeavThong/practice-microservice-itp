package com.thong.account_query.data.entity;


import com.thong.common.domain.valueobject.AccountStatus;
import com.thong.common.domain.valueobject.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEnity {

    @Id
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

    @ManyToOne(fetch = FetchType.LAZY)
    AccountEnity accountEnity;

}
