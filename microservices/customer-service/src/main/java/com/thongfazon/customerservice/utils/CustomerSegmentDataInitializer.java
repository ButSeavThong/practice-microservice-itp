package com.thongfazon.customerservice.utils;

import com.thongfazon.customerservice.data.entity.CustomerSegmentEntity;
import com.thongfazon.customerservice.data.repository.CustomerSegmentRepository;
import com.thongfazon.customerservice.domain.valueobject.CustomerSegmentType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerSegmentDataInitializer implements CommandLineRunner {

    private final CustomerSegmentRepository repository;

    @Override
    public void run(String... args) {

        if (repository.count() > 0) {
            return; // already initialized
        }
        for (CustomerSegmentType type : CustomerSegmentType.values()) {

            CustomerSegmentEntity segment = new CustomerSegmentEntity();
//            segment.setCustomerSegmentId(UUID.randomUUID());
            segment.setCustomerSegmentType(type);
            repository.save(segment);
        }
    }
}