package com.thongfazon.account.domain.validate;

import com.thongfazon.account.domain.exception.AccountDomainException;

public class AccountValidate {

    public static void validateAccountNumber(String accountNumber) {

        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new AccountDomainException("Invalid account number, cannot be empty");
        }

        if (!accountNumber.matches("^[0-9]{10}$")) {
            throw new AccountDomainException("Invalid account number, must be exactly 10 numeric digits");
        }
    }
}
