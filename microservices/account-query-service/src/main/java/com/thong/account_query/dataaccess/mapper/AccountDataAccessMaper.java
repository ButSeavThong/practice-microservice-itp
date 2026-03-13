package com.thong.account_query.dataaccess.mapper;


import com.thong.account_query.dataaccess.entity.AccountEntity;
import com.thong.account_query.domain.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountDataAccessMaper {

    AccountEntity  accountToAccountEntity(Account account);

    Account accountEntityToAccount(AccountEntity account);
}
