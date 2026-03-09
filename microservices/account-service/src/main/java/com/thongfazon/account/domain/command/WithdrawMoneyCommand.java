package com.thongfazon.account.domain.command;

import com.thong.common.domain.valueobject.AccountId;
import com.thongfazon.account.domain.valueobject.Money;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record WithdrawMoneyCommand(
        @TargetAggregateIdentifier
        AccountId accountId,
        Money amount,
        String remark
) {
}
