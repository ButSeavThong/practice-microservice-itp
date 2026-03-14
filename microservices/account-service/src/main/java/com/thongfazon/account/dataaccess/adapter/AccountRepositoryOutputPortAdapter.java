package com.thongfazon.account.dataaccess.adapter;

import com.thongfazon.account.appliactionservice.ports.output.AccountRepositoryOutputPort;
import com.thongfazon.account.domain.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class AccountRepositoryOutputPortAdapter implements AccountRepositoryOutputPort {

    @Override
    public Account save(Account account) {

        return null;
    }
}
