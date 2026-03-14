package com.thongfazon.account.appliactionservice.ports.output;

import com.thongfazon.account.domain.entity.Account;


public interface AccountRepositoryOutputPort {
    Account save(Account account);
}
