package com.thongfazon.account.infrastructure.rest.controller;


import com.thongfazon.account.appliactionservice.ports.input.AccountCommandServiceInputPort;
import com.thongfazon.account.appliactionservice.dto.create.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController
{
    private final AccountCommandServiceInputPort accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountResponse createAccount(@RequestBody  CreateAccountRequest createAccountRequest){
        return accountService.createAccount(createAccountRequest);
    }

    @PostMapping ("/deposit")
    public DepositMoneyResponse depositMoney( @Valid @RequestBody DepositMoneyRequest depositMoneyRequest){
        return accountService.depositMoney(depositMoneyRequest);
    }

    @PostMapping("/withdraw")
    public WithdrawMoneyResponse withdrawMoney(@Valid @RequestBody WithdrawMoneyRequest withdrawMoneyRequest){
        return accountService.withdrawMoney(withdrawMoneyRequest);
    }


}
