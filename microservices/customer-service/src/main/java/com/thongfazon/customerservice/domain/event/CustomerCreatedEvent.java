package com.thongfazon.customerservice.domain.event;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.CustomerSegmentId;
import com.thongfazon.customerservice.domain.valueobject.*;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CustomerCreatedEvent(
        CustomerId customerId,
        CustomerName name,
        CustomerGender gender,
        LocalDate dob,
        CustomerEmail email,
        String phoneNumber,
        Contact contact,
        Address address,
        Kyc kyc,
        CustomerSegmentId customerSegmentId
) {
}
