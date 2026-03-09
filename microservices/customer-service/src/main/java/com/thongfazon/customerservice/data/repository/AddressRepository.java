package com.thongfazon.customerservice.data.repository;

import com.thongfazon.customerservice.data.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {

}
