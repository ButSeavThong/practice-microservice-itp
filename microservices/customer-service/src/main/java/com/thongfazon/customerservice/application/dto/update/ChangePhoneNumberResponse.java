package com.thongfazon.customerservice.application.dto.update;


import com.thong.common.domain.valueobject.CustomerId;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ChangePhoneNumberResponse(
        @NotBlank
        CustomerId customerId,

        @NotBlank
        String phoneNumber,


        @NotBlank
        String message

) {
}
