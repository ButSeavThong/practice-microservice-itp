package com.thong.account_query.dataaccess.entity;

import com.thong.common.domain.valueobject.AccountStatus;
import com.thong.common.domain.valueobject.Currency;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    private UUID accountId;

    private UUID customerId;

    private UUID branchId;

    private UUID accountTypeId;

    private String accountNumber;

    private String accountHolder;

    private BigDecimal balance;

    private Currency currency;

    private AccountStatus accountStatus;

    private String createdBy;

    private String updatedBy;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

}