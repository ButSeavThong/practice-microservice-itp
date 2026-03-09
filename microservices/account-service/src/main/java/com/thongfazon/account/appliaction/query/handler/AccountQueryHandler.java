package com.thongfazon.account.appliaction.query.handler;


import com.thongfazon.account.appliaction.dto.query.AccountQueryResponse;
import com.thongfazon.account.data.entity.AccountEnity;
import com.thongfazon.account.data.repository.AccountRepository;
import com.thongfazon.account.data.repository.BranchRepository;
import com.thongfazon.account.domain.event.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountQueryHandler {

    private final BranchRepository branchRepository;
    private final AccountRepository accountRepository;

    @QueryHandler
    public AccountQueryResponse handle(AccountCreatedEvent accountCreatedEvent){
        // validate here.
        AccountEnity accountEnity = new AccountEnity();
        accountRepository.saveAndFlush(accountEnity);

        return AccountQueryResponse.builder().build();
    }
}
