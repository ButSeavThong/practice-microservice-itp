package com.thongfazon.account.domain.event;


import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.CustomerId;
import com.thongfazon.account.domain.valueobject.Money;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.ZonedDateTime;

@Builder
public record MoneyWithdrawnEvent(
        @TargetAggregateIdentifier
        AccountId accountId,
        CustomerId customerId,
        Money amount,
        Money newBalance,
        String remark,
        ZonedDateTime createdAt
) {
}
