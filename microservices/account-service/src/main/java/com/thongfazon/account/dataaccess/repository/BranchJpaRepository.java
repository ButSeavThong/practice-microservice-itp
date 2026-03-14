package com.thongfazon.account.dataaccess.repository;

import com.thongfazon.account.dataaccess.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BranchJpaRepository extends JpaRepository<BranchEntity, UUID> {

}
