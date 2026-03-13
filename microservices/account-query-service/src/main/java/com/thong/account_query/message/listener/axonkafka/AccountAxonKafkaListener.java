package com.thong.account_query.message.listener.axonkafka;


import com.thong.account_query.applicationservice.ports.input.message.listener.AccountMessageListener;
import com.thong.common.domain.event.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@ProcessingGroup("account-group")
public class AccountAxonKafkaListener {
    private final AccountMessageListener messageListener;


    @EventHandler
    public void onAccountCreatedEvent(AccountCreatedEvent event) {
        messageListener.onAccountCreatedEvent(event);
        log.info("onAccountCreatedEvent {} ", event);
    }
}
