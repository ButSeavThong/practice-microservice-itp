package com.thongfazon.customerservice.domain.command;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.CustomerSegmentId;
import com.thongfazon.customerservice.domain.valueobject.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

public record CreateCustomerCommand(
        @TargetAggregateIdentifier
        CustomerId customerId,
        CustomerName name,
        CustomerGender gender,
        LocalDate dob,
        String phoneNumber,
        CustomerEmail email,
        Contact contact,
        Address address,
        Kyc kyc,
        CustomerSegmentId customerSegmentId

) {
}
