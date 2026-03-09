package com.thongfazon.account.domain.command;

import com.thong.common.domain.valueobject.AccountId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record FreezeAccountCommand(
        @TargetAggregateIdentifier
        AccountId accountId,
        String remark,
        String requestedBy
) {
}
