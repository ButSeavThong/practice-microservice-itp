package com.thong.account_query.applicationservice.ports.input.message.adapter;

import com.thong.account_query.applicationservice.mapper.AccountAppDataMapper;
import com.thong.account_query.applicationservice.ports.input.message.listener.AccountMessageListener;
import com.thong.account_query.applicationservice.ports.output.service.AccountQueryRepositoryPort;
import com.thong.account_query.domain.entity.Account;
import com.thong.common.domain.event.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountMessageListenerImpl implements AccountMessageListener {
    private final AccountQueryRepositoryPort accountQueryRepositoryPort;
    private final AccountAppDataMapper accountAppDataMapper;
    @Override
    public void onAccountCreatedEvent(AccountCreatedEvent event) {
        Account account = accountAppDataMapper.accountCreatedEventToAccount(event);
        accountQueryRepositoryPort.save(account)
                .subscribe();
    }
}
