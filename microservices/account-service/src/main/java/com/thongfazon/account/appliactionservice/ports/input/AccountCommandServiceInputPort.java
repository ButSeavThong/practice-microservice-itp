package com.thongfazon.account.appliactionservice.ports.input;

import com.thongfazon.account.appliactionservice.dto.create.*;

public interface AccountCommandServiceInputPort {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);
    DepositMoneyResponse depositMoney(DepositMoneyRequest depositMoneyRequest);
    WithdrawMoneyResponse withdrawMoney(WithdrawMoneyRequest withdrawMoneyRequest);
}
