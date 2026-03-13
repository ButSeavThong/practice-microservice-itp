package com.thong.account_query.applicationservice.ports.input.service;

import com.thong.account_query.applicationservice.dto.AccountQueryResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountQueryService  {

    Mono<AccountQueryResponse> getAccountById(UUID accountId);
}
