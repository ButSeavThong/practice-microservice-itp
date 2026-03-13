package com.thong.account_query.rest;


import com.thong.account_query.applicationservice.dto.AccountQueryResponse;
import com.thong.account_query.applicationservice.ports.input.service.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountQueryController {
    private final AccountQueryService accountQueryService;

    @GetMapping("/{accountId}")
    Mono<AccountQueryResponse> getAccountById(@PathVariable UUID accountId){
        return accountQueryService.getAccountById(accountId);
    }
}
