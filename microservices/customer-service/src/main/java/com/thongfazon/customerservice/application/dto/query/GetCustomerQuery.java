package com.thongfazon.customerservice.application.dto.query;

import lombok.Builder;

@Builder
public record GetCustomerQuery(
            int page,
            int size
) {

}
