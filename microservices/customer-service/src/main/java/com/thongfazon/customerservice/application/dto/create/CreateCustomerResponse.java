package com.thongfazon.customerservice.application.dto.create;

import com.thong.common.domain.valueobject.CustomerId;
import lombok.Builder;

@Builder
public record CreateCustomerResponse(
        CustomerId customerId,
        String message
) {
}
