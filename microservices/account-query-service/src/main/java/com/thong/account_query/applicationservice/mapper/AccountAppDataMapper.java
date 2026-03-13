package com.thong.account_query.applicationservice.mapper;


import com.thong.account_query.applicationservice.dto.AccountQueryResponse;
import com.thong.account_query.domain.entity.Account;
import com.thong.common.domain.event.AccountCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountAppDataMapper {
    AccountQueryResponse accountToAccountQueryResponse(Account account);

    @Mapping(target = "accountId", source = "accountId.value")
    @Mapping(target = "customerId", source = "customerId.value")
    @Mapping(target = "branchId", source = "branchId.value")
    Account accountCreatedEventToAccount(AccountCreatedEvent accountCreatedEvent);
}
