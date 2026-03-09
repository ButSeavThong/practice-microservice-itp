package com.thongfazon.account.data.repository;

import com.thongfazon.account.data.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BranchRepository  extends JpaRepository<BranchEntity, UUID> {

}
