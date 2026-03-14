package com.thongfazon.account.appliactionservice.query.projection;


import com.thong.common.domain.event.AccountCreatedEvent;
import com.thongfazon.account.appliactionservice.mapper.AccountMapper;
import com.thongfazon.account.dataaccess.entity.AccountEnity;
import com.thongfazon.account.dataaccess.repository.AccountJpaRepository;
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
    private final AccountJpaRepository accountJpaRepository;
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
        accountJpaRepository.save(enity);
    }

}
