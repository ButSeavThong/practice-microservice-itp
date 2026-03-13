package com.thong.account_query.dataaccess.repository;

import com.thong.account_query.dataaccess.entity.AccountEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountQueryReactiveRepository extends R2dbcRepository<AccountEntity, UUID> {
}
