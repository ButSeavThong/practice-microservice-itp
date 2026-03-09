package com.thongfazon.account.appliaction.command;

import com.thongfazon.account.appliaction.dto.create.*;

public interface AccountService {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);
    DepositMoneyResponse depositMoney(DepositMoneyRequest depositMoneyRequest);
    WithdrawMoneyResponse withdrawMoney(WithdrawMoneyRequest withdrawMoneyRequest);
}
