package com.thongfazon.customerservice.data.repository;

import com.thongfazon.customerservice.data.entity.KycEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KycRepository extends JpaRepository<KycEntity, UUID> {
}
