package com.thongfazon.account.domain.valueobject;

import java.util.UUID;

public record TransactionId(UUID value) {
    public static TransactionId of(UUID value) {
        return new TransactionId(value);
    }
    public static TransactionId generate() {
        return new TransactionId(UUID.randomUUID());
    }
}
