package com.thongfazon.account.appliactionservice.dto.create;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.AccountTypeCode;
import com.thong.common.domain.valueobject.BranchId;
import com.thong.common.domain.valueobject.Money;

public record CreateAccountRequest(
        String accountNumber,
        String accountHolder,
        CustomerId customerId,
        AccountTypeCode accountTypeCode,
        BranchId branchId,
        Money initialBalance
) {
}
