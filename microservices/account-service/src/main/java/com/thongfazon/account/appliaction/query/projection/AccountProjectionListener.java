package com.thongfazon.account.appliaction.query.projection;


import com.thong.common.domain.event.AccountCreatedEvent;
import com.thongfazon.account.appliaction.mapper.AccountMapper;
import com.thongfazon.account.data.entity.AccountEnity;
import com.thongfazon.account.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@ProcessingGroup("account-group")
public class AccountProjectionListener {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @EventHandler
    public void handle(AccountCreatedEvent accountCreatedEvent) {
        if (accountCreatedEvent.accountId() == null) {
            throw new RuntimeException("Account id is null");
        }
        if (accountCreatedEvent.accountNumber() == null) {
            throw new RuntimeException("Account number is null");
        }
        AccountEnity enity = accountMapper.accountCreatedEventToAccountEnity(accountCreatedEvent);
        accountRepository.save(enity);
    }

}
