package com.thongfazon.customerservice.domain.valueobject;

import java.util.UUID;

public record Kyc(
        UUID kycId,
        String kycType,
        String kycNumber
) {
}
