package com.thong.account_query.dataaccess.entity;

import com.thong.common.domain.valueobject.AccountTypeCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account_types")
public class AccountTypeEntity {

    @Id
    private UUID accountTypeId;

    private AccountTypeCode accountTypeCode;

}