package com.thong.common.domain.valueobject;

import java.util.UUID;

public record CustomerSegmentId(
        UUID customerSegmentId
) {
    @Override
    public String toString() {
        return customerSegmentId.toString();
    }
}
