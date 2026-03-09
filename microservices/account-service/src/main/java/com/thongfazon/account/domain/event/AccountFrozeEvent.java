package com.thongfazon.account.domain.event;

import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.AccountStatus;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.ZonedDateTime;

public record AccountFrozeEvent(
        @TargetAggregateIdentifier
        AccountId accountId,
        CustomerId customerId,
        AccountStatus previousStatus,
        AccountStatus newStatus,
        String reason,
        String requestBy,
        ZonedDateTime createdAt
) {
}
