package com.thongfazon.account.appliaction.dto.create;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.AccountTypeCode;
import com.thongfazon.account.domain.valueobject.BranchId;
import com.thongfazon.account.domain.valueobject.Money;

public record CreateAccountRequest(
        String accountNumber,
        String accountHolder,
        CustomerId customerId,
        AccountTypeCode accountTypeCode,
        BranchId branchId,
        Money initialBalance
) {
}
