package com.thong.account_query.applicationservice.ports.input.message.listener;

import com.thong.common.domain.event.AccountCreatedEvent;

public interface AccountMessageListener {
    void onAccountCreatedEvent(AccountCreatedEvent event);
}
