package com.thongfazon.account.appliaction.dto.create;

import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.Money;
import lombok.Builder;

@Builder

public record DepositMoneyRequest(
        AccountId accountId,
        Money amount,
        String remark

) {
}
