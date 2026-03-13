package com.thong.account_query.applicationservice.serviceImpl;

import com.thong.account_query.applicationservice.dto.AccountQueryResponse;
import com.thong.account_query.applicationservice.mapper.AccountAppDataMapper;
import com.thong.account_query.applicationservice.ports.input.service.AccountQueryService;
import com.thong.account_query.applicationservice.ports.output.service.AccountQueryRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Log4j2
public class AccountQueryServiceImpl implements AccountQueryService {
    private final AccountQueryRepositoryPort accountQueryRepositoryPort;
    private final AccountAppDataMapper accountAppDataMapper;

    @Override
    public Mono<AccountQueryResponse> getAccountById(UUID accountId) {
        return accountQueryRepositoryPort.findById(accountId)
                .map(accountAppDataMapper::accountToAccountQueryResponse);
    }
}
