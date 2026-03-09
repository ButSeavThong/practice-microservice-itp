package com.thongfazon.customerservice.application.dto.query;

import com.thongfazon.customerservice.domain.valueobject.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerQueryResponse(
        UUID customerId,
        @NotNull
        CustomerName name,
        @NotNull
        CustomerEmail email,
        @NotNull
        CustomerGender gender,
        @NotNull
        LocalDate dob,
        @NotNull
        Kyc kyc,
        @NotNull
        Address address,
        @NotNull
        Contact contact,
        @NotBlank @NotNull
        String phoneNumber,
        @NotNull
        CustomerSegmentResponse customerSegment


) {
}
