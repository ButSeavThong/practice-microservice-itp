package com.thong.account_query.dataaccess.adapter;

import com.thong.account_query.applicationservice.ports.output.service.AccountQueryRepositoryPort;
import com.thong.account_query.dataaccess.entity.AccountEntity;
import com.thong.account_query.dataaccess.mapper.AccountDataAccessMaper;
import com.thong.account_query.dataaccess.repository.AccountQueryReactiveRepository;
import com.thong.account_query.domain.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Repository
@RequiredArgsConstructor
@Slf4j
public class AccountRepositoryAdapter implements AccountQueryRepositoryPort {

    private final AccountQueryReactiveRepository accountQueryReactiveRepository;
    private final AccountDataAccessMaper accountDataAccessMaper;

    @Override
    public Mono<Account> save(Account account) {
        log.info("Saving account {}", account);
        AccountEntity  accountEntity = accountDataAccessMaper.accountToAccountEntity(account);
        return accountQueryReactiveRepository.save(accountEntity)
                .map(accountDataAccessMaper::accountEntityToAccount);
    }


    @Override
    public Mono<Account> findById(UUID accountId) {
        return accountQueryReactiveRepository.findById(accountId)
                .map(accountDataAccessMaper::accountEntityToAccount);
    }
}
