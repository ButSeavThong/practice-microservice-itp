package com.thong.common.domain.valueobject;

import java.util.UUID;

public record BranchId(UUID value) {
    public static BranchId of(UUID value) { return new BranchId(value); }
}
