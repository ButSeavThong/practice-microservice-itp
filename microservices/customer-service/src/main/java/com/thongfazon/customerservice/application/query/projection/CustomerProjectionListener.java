package com.thongfazon.customerservice.application.query.projection;


import com.thongfazon.customerservice.application.mapper.CustomerApplicationMapper;
import com.thongfazon.customerservice.data.entity.CustomerEntity;
import com.thongfazon.customerservice.data.entity.CustomerSegmentEntity;
import com.thongfazon.customerservice.data.repository.CustomerRepository;
import com.thongfazon.customerservice.data.repository.CustomerSegmentRepository;
import com.thongfazon.customerservice.domain.event.CustomerCreatedEvent;
import com.thongfazon.customerservice.domain.event.CustomerPhoneNumberChangedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
@Slf4j
@ProcessingGroup("customer-group")
public class CustomerProjectionListener {
    private final CustomerRepository customerRepository;
    private final CustomerApplicationMapper customerApplicationMapper;
    private final CustomerSegmentRepository segmentRepository;
    private final CustomerSegmentRepository customerSegmentRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event) {
        log.info("Customer created: {}",event);

        if (!segmentRepository.existsById(event.customerSegmentId().customerSegmentId())) {
            throw new RuntimeException("Segment not found");
        }

        CustomerEntity customer = customerApplicationMapper
                .customerCreatedEventToCustomerEntity(event);

        customer.getContact().setCustomer(customer);
        customer.getAddress().setCustomer(customer);
        customer.getKyc().setCustomer(customer);


        CustomerSegmentEntity customerSegmentEntity = customerSegmentRepository.findById(event.customerSegmentId().customerSegmentId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Segment not found"));
        customer.setCustomerSegment(customerSegmentEntity);


        customerRepository.save(customer);
    }

    @EventHandler
    public void on(CustomerPhoneNumberChangedEvent customerPhoneNumberChangedEvent) {
        log.info("Customer phone number changed: {}",customerPhoneNumberChangedEvent);

    }



}
