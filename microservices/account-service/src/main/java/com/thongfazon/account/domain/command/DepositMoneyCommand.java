package com.thongfazon.account.domain.command;

import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.Money;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record DepositMoneyCommand(
        @TargetAggregateIdentifier
        AccountId accountId,
        Money amount,
        String remark
) {
}
