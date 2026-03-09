package com.thongfazon.customerservice.application.dto.update;


import jakarta.validation.constraints.NotBlank;

public record ChangePhoneNumberRequest(
        @NotBlank
        String phoneNumber
) {
}
