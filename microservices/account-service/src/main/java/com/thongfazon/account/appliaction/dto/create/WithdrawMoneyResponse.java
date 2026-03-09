package com.thongfazon.account.appliaction.dto.create;

import com.thong.common.domain.valueobject.AccountId;
import com.thongfazon.account.domain.valueobject.Money;
import lombok.Builder;

@Builder
public record WithdrawMoneyResponse(
        AccountId accountId,
        Money withdrawnAmount,
        String message
) {
}
