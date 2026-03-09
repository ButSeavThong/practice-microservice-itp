package com.thongfazon.account.domain.command;

import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.AccountTypeCode;
import com.thong.common.domain.valueobject.CustomerId;
import com.thongfazon.account.domain.valueobject.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record CreateAccountCommand(
        @TargetAggregateIdentifier
        AccountId accountId,
        String accountNumber,
        String accountHolder,
        CustomerId customerId,
        AccountTypeCode accountTypeCode,
        BranchId branchId,
        Money initialBalance

) {
}
