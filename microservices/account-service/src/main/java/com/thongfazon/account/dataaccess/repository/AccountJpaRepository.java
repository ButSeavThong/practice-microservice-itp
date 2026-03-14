package com.thongfazon.account.dataaccess.repository;

import com.thongfazon.account.dataaccess.entity.AccountEnity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository<AccountEnity, UUID> {

}