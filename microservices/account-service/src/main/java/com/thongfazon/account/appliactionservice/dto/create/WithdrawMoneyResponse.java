package com.thongfazon.account.appliactionservice.dto.create;

import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.Money;
import lombok.Builder;

@Builder
public record WithdrawMoneyResponse(
        AccountId accountId,
        Money withdrawnAmount,
        String message
) {
}
