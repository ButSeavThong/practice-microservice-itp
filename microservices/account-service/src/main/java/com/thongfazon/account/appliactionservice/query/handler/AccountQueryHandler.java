package com.thongfazon.account.appliactionservice.query.handler;


import com.thongfazon.account.appliactionservice.dto.query.AccountQueryResponse;
import com.thongfazon.account.dataaccess.entity.AccountEnity;
import com.thongfazon.account.dataaccess.repository.AccountJpaRepository;
import com.thongfazon.account.dataaccess.repository.BranchJpaRepository;
import com.thongfazon.account.domain.event.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountQueryHandler {

    private final BranchJpaRepository branchJpaRepository;
    private final AccountJpaRepository accountJpaRepository;

    @QueryHandler
    public AccountQueryResponse handle(AccountCreatedEvent accountCreatedEvent){
        // validate here.
        AccountEnity accountEnity = new AccountEnity();
        accountJpaRepository.saveAndFlush(accountEnity);

        return AccountQueryResponse.builder().build();
    }
}
