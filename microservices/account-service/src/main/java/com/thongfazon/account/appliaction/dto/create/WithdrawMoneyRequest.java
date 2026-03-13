package com.thongfazon.account.appliaction.dto.create;

import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.Money;

public record WithdrawMoneyRequest(
        AccountId accountId,
        Money amount,
        String remark
) {
}
