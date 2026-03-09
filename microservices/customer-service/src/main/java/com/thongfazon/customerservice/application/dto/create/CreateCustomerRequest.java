package com.thongfazon.customerservice.application.dto.create;

import com.thong.common.domain.valueobject.CustomerSegmentId;
import com.thongfazon.customerservice.domain.valueobject.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateCustomerRequest(

        @NotBlank
        CustomerName name,

        @NotBlank
        CustomerGender gender,

        @NotBlank
        LocalDate dob,

        @NotBlank
        CustomerEmail email,

        @NotBlank
        Contact contact,

        @NotBlank
        String  phoneNumber,

        @NotBlank
        Address address,

        @NotBlank
        Kyc kyc,

        @NotBlank
        CustomerSegmentId customerSegmentId


) {
}

