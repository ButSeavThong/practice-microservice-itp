package com.thongfazon.account.domain.valueobject;

import java.util.UUID;

public record AccountTypeId(UUID value) {
    public static AccountTypeId of(UUID value) {
        return new AccountTypeId(value);
    }
}
