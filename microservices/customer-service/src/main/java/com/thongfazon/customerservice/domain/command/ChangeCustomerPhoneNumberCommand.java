package com.thongfazon.customerservice.domain.command;

import com.thong.common.domain.valueobject.CustomerId;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record ChangeCustomerPhoneNumberCommand(
        @TargetAggregateIdentifier
        CustomerId customerId,

        String phoneNumber
) {
}
