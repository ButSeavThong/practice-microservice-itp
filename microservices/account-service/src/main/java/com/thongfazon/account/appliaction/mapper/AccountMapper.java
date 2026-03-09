package com.thongfazon.account.appliaction.mapper;


import com.thong.common.domain.valueobject.AccountId;
import com.thongfazon.account.appliaction.dto.create.CreateAccountRequest;
import com.thongfazon.account.appliaction.dto.create.DepositMoneyRequest;
import com.thongfazon.account.appliaction.dto.create.WithdrawMoneyRequest;
import com.thongfazon.account.domain.command.CreateAccountCommand;
import com.thongfazon.account.domain.command.DepositMoneyCommand;
import com.thongfazon.account.domain.command.WithdrawMoneyCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    CreateAccountCommand createAccountRequestToCreateAccountCommand(AccountId accountId, CreateAccountRequest  createAccountRequest);
    DepositMoneyCommand toDepositMoneyCommand(DepositMoneyRequest depositMoneyRequest);
    WithdrawMoneyCommand toWithdrawMoneyCommand(WithdrawMoneyRequest withdrawMoneyRequest);

}
