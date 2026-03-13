package com.thong.account_query.applicationservice.ports.output.service;


import com.thong.account_query.domain.entity.Account;
import reactor.core.publisher.Mono;

import java.util.UUID;

// output port for data accesss tng
    public interface AccountQueryRepositoryPort {

    Mono<Account> save(Account account);
    Mono<Account> findById(UUID accountId);
}
