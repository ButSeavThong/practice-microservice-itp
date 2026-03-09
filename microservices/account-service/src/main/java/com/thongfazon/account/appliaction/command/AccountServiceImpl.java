package com.thongfazon.account.appliaction.command;

import com.thong.common.domain.valueobject.AccountId;
import com.thongfazon.account.appliaction.dto.create.*;
import com.thongfazon.account.appliaction.mapper.AccountMapper;
import com.thongfazon.account.domain.command.CreateAccountCommand;
import com.thongfazon.account.domain.command.DepositMoneyCommand;
import com.thongfazon.account.domain.command.WithdrawMoneyCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final CommandGateway commandGateway;
    private final AccountMapper accountMapper;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        log.info("CreateAccountRequest {}", createAccountRequest);

        AccountId newAccountId = new AccountId(UUID.randomUUID());
        CreateAccountCommand createAccountCommand = accountMapper.createAccountRequestToCreateAccountCommand(newAccountId, createAccountRequest);
        commandGateway.sendAndWait(createAccountCommand);

        return CreateAccountResponse.builder()
                .accountId(newAccountId.toString())
                .accountNumber(createAccountCommand.accountNumber())
                .accountHolder(createAccountCommand.accountHolder())
                .message("Account has been created successfully")
                .build();
    }

    @Override
    public DepositMoneyResponse depositMoney(DepositMoneyRequest depositMoneyRequest) {
        DepositMoneyCommand depositMoneyCommand = accountMapper.toDepositMoneyCommand(depositMoneyRequest);
        AccountId accountId = commandGateway.sendAndWait(depositMoneyCommand);
        return DepositMoneyResponse.builder()
                .accountId(accountId)
                .depositedAmount(depositMoneyCommand.amount())
                .message("Deposit money has been successfully")
                .build();
    }

    @Override
    public WithdrawMoneyResponse withdrawMoney(WithdrawMoneyRequest withdrawMoneyRequest) {
        WithdrawMoneyCommand command = accountMapper.toWithdrawMoneyCommand(withdrawMoneyRequest);
        AccountId accountId = commandGateway.sendAndWait(command);
        return WithdrawMoneyResponse.builder()
                .accountId(accountId)
                .withdrawnAmount(withdrawMoneyRequest.amount())
                .message("Withdraw money has been successfully")
                .build();
    }
}
