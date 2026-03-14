package com.thongfazon.account.appliactionservice.mapper;


import com.thong.common.domain.event.AccountCreatedEvent;
import com.thong.common.domain.valueobject.AccountId;
import com.thongfazon.account.appliactionservice.dto.create.CreateAccountRequest;
import com.thongfazon.account.appliactionservice.dto.create.DepositMoneyRequest;
import com.thongfazon.account.appliactionservice.dto.create.WithdrawMoneyRequest;
import com.thongfazon.account.dataaccess.entity.AccountEnity;
import com.thongfazon.account.domain.command.CreateAccountCommand;
import com.thongfazon.account.domain.command.DepositMoneyCommand;
import com.thongfazon.account.domain.command.WithdrawMoneyCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    CreateAccountCommand createAccountRequestToCreateAccountCommand(AccountId accountId, CreateAccountRequest  createAccountRequest);
    DepositMoneyCommand toDepositMoneyCommand(DepositMoneyRequest depositMoneyRequest);
    WithdrawMoneyCommand toWithdrawMoneyCommand(WithdrawMoneyRequest withdrawMoneyRequest);

    @Mapping(target = "accountId", source = "accountId.value")
    @Mapping(target = "customerId", source = "customerId.value")
    @Mapping(target = "branchId", source = "branchId.value")
    AccountEnity accountCreatedEventToAccountEnity(AccountCreatedEvent accountCreatedEvent);
}
