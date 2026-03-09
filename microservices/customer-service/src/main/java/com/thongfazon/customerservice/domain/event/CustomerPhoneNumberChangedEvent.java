package com.thongfazon.customerservice.domain.event;

import com.thong.common.domain.valueobject.CustomerId;
import lombok.Builder;

@Builder
public record CustomerPhoneNumberChangedEvent(
        CustomerId customerId,
        String phoneNumber
) {
}
