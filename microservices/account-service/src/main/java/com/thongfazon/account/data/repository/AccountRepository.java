package com.thongfazon.account.data.repository;

import com.thongfazon.account.data.entity.AccountEnity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEnity, UUID> {

}