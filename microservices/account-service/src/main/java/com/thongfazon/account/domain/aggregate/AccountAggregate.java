package com.thongfazon.account.domain.aggregate;


import com.thong.common.domain.valueobject.AccountId;
import com.thong.common.domain.valueobject.AccountStatus;
import com.thong.common.domain.valueobject.AccountTypeCode;
import com.thong.common.domain.valueobject.CustomerId;
import com.thongfazon.account.domain.command.CreateAccountCommand;
import com.thongfazon.account.domain.command.DepositMoneyCommand;
import com.thongfazon.account.domain.command.FreezeAccountCommand;
import com.thongfazon.account.domain.command.WithdrawMoneyCommand;
import com.thongfazon.account.domain.event.AccountCreatedEvent;
import com.thongfazon.account.domain.event.MoneyDepositedEvent;
import com.thongfazon.account.domain.event.MoneyWithdrawnEvent;
import com.thongfazon.account.domain.event.AccountFrozeEvent;
import com.thongfazon.account.domain.exception.AccountDomainException;
import com.thongfazon.account.domain.validate.AccountValidate;
import com.thongfazon.account.domain.valueobject.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
@Slf4j
@EqualsAndHashCode
@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private AccountId accountId;

    private CustomerId customerId;
    private BranchId branchId;
    private AccountStatus accountStatus;
    private AccountTypeCode accountTypeCode;
    private Money balance;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private String remark;

    private void validateAccountType(AccountTypeCode accountTypeCode) {
        if(accountTypeCode == null) {
            throw  new AccountDomainException("Account type code cannot be null");
        }
        if(accountTypeCode != AccountTypeCode.SAVING){
            throw  new AccountDomainException("Account type code must be SAVING");
        }
    }
    private void validateInitialBalance(Money initialBalance) {
        Money minInitialBalance = Money.of(BigDecimal.valueOf(10), Currency.USD);

        if (initialBalance.isLessThan(minInitialBalance)) {
            throw new AccountDomainException("Initial balance must be at least $10");
        }
    }
    // flow : when we call commandGateway.sendAndWait() axon will auto load event from domain event entry it will rebuild state base on current state latest

        @CommandHandler
        public AccountAggregate (CreateAccountCommand createAccountCommand){
            log.info("Aggregate on or Creating account command {}", createAccountCommand);

            // validate account number
            AccountValidate.validateAccountNumber(createAccountCommand.accountNumber());

            // validate accountTypeCode
            validateAccountType(createAccountCommand.accountTypeCode());

            // validate balance
            validateInitialBalance(createAccountCommand.initialBalance());

            // create event object
            AccountCreatedEvent accountCreatedEvent = AccountCreatedEvent.builder()
                    .accountId(createAccountCommand.accountId())
                    .accountNumber(createAccountCommand.accountNumber())
                    .accountHolder(createAccountCommand.accountHolder())
                    .customerId(createAccountCommand.customerId())
                    .createdAt(ZonedDateTime.now())
                    .branchId(createAccountCommand.branchId())
                    .accountTypeCode(createAccountCommand.accountTypeCode())
                    .initialBalance(createAccountCommand.initialBalance())
                    .status(AccountStatus.ACTIVE)
                    .createdBy(createAccountCommand.customerId().toString())
                    .build();
            log.info("Created account event {}", accountCreatedEvent);
            AggregateLifecycle.apply(accountCreatedEvent);

        }

        @EventSourcingHandler
        public void on(AccountCreatedEvent accountCreatedEvent) {
            this.accountId = accountCreatedEvent.accountId();
            this.customerId = accountCreatedEvent.customerId();
            this.branchId = accountCreatedEvent.branchId();
            this.accountTypeCode = accountCreatedEvent.accountTypeCode();
            this.balance = accountCreatedEvent.initialBalance();
            this.createdAt = ZonedDateTime.now();
            this.updatedAt = accountCreatedEvent.createdAt();
            this.updatedBy = accountCreatedEvent.customerId().toString();
            this.accountTypeCode = accountCreatedEvent.accountTypeCode();
            this.accountStatus = accountCreatedEvent.status();
            this.createdBy = accountCreatedEvent.createdBy();
        }


        @CommandHandler
         public AccountId handle(DepositMoneyCommand command){
            if (this.accountStatus == AccountStatus.FREEZE || this.accountStatus == AccountStatus.CLOSED) {
                throw new AccountDomainException("Account is frozen");
            }
            if (command.amount() == null) {
                throw new AccountDomainException("Amount cannot be null");
            }
            if (command.amount().isLessThan(this.balance)) {
                throw new AccountDomainException("Deposit amount must be greater than 0");
            }
            Money newBalance = this.balance.add(command.amount());

            MoneyDepositedEvent depositedEvent = MoneyDepositedEvent.builder()
                    .accountId(command.accountId())
                    .amount(command.amount())
                    .newBalance(newBalance)
                    .remark(command.remark())
                    .createdAt(ZonedDateTime.now())
                    .customerId(customerId)
                    .build();
            log.info("Deposited account event {}", depositedEvent);
            AggregateLifecycle.apply(depositedEvent);
            return  new AccountId(depositedEvent.accountId().value());
        }

        @EventSourcingHandler
        public void on(MoneyDepositedEvent depositedEvent) {
            log.info("Deposit event {}", depositedEvent);
            this.balance = depositedEvent.newBalance();
            this.createdAt = depositedEvent.createdAt();
            this.updatedAt = depositedEvent.createdAt();
        }

        @CommandHandler
        public AccountId handle( WithdrawMoneyCommand command){
            if (this.accountStatus == AccountStatus.FREEZE || this.accountStatus == AccountStatus.CLOSED) {
                throw new AccountDomainException("Account is frozen");
            }
            if (command.amount() == null) {
                throw new AccountDomainException("Amount cannot be null");
            }


            Money newBalance = this.balance.subtract(command.amount());

            MoneyWithdrawnEvent withdrawnEvent = MoneyWithdrawnEvent.builder()
                    .accountId(command.accountId())
                    .amount(command.amount())
                    .newBalance(newBalance)
                    .remark(command.remark())
                    .createdAt(ZonedDateTime.now())
                    .customerId(customerId)
                    .build();
            log.info("Withdrawn account event {}", withdrawnEvent);

            AggregateLifecycle.apply(withdrawnEvent);
            return  new AccountId(withdrawnEvent.accountId().value());

        }

        @EventSourcingHandler
        public void on(MoneyWithdrawnEvent withdrawnEvent) {
            this.balance = withdrawnEvent.newBalance();
            this.createdAt = withdrawnEvent.createdAt();
            this.updatedAt = withdrawnEvent.createdAt();
            this.createdBy = withdrawnEvent.customerId().toString();
            this.remark = withdrawnEvent.remark();
        }


    private void validateAccountIsFreeze(){
        if (this.accountStatus == AccountStatus.CLOSED) {
            throw new AccountDomainException("Only ACTIVE accounts can be frozen. Current status: " + this.accountStatus);
        }
        if (this.accountStatus == AccountStatus.FREEZE){
            throw new AccountDomainException("Can not freeze this account! Account is freeze");
        }
    }
    @CommandHandler
    public void handle(FreezeAccountCommand command){
        log.info("Handling FreezeAccountCommand for accountId = {}", command.accountId().value());
        validateAccountIsFreeze();
        AggregateLifecycle.apply(new AccountFrozeEvent(
                this.accountId,
                this.customerId,
                this.accountStatus,
                AccountStatus.FREEZE,
                command.remark(),
                command.requestedBy(),
                ZonedDateTime.now()
        ));
    }

    @EventSourcingHandler
    public void on(AccountFrozeEvent event){
        this.accountStatus = event.newStatus();
        this.updatedAt = event.createdAt();
        this.updatedBy = event.requestBy();
        log.info("AccountFrozenEvent applied: accountId={}, status={} -> {}",
                event.accountId().value(),
                event.previousStatus(),
                event.newStatus()
        );
    }





}
