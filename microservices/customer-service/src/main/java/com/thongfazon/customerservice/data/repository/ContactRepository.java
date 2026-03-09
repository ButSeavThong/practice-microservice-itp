package com.thongfazon.customerservice.data.repository;

import com.thongfazon.customerservice.data.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {

}
