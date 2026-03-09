package com.thongfazon.customerservice.domain.aggregate;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.CustomerSegmentId;
import com.thongfazon.customerservice.domain.command.ChangeCustomerPhoneNumberCommand;
import com.thongfazon.customerservice.domain.command.CreateCustomerCommand;
import com.thongfazon.customerservice.domain.event.CustomerCreatedEvent;
import com.thongfazon.customerservice.domain.event.CustomerPhoneNumberChangedEvent;
import com.thongfazon.customerservice.domain.valueobject.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Slf4j
@EqualsAndHashCode
@Aggregate(snapshotTriggerDefinition = "customerSnapshotTrigger")
public class CustomerAggregate {

    @AggregateIdentifier
    private CustomerId customerId;

    private CustomerName name;
    private CustomerGender gender;
    private CustomerEmail email;
    private LocalDate dob;
    private Kyc kyc;
    private Address address;
    private Contact contact;
    private CustomerSegmentId customerSegmentId;
    private String phoneNumber;

    /**
     * Command Handler Constructor
     * Used when creating a new Aggregate
     */
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {

        log.info("Handling CreateCustomerCommand: {}", command);
        // validate by bellow method
        validateCreateCustomer(command);

        CustomerCreatedEvent event = CustomerCreatedEvent.builder()
                .customerId(command.customerId())
                .name(command.name())
                .gender(command.gender())
                .dob(command.dob())
                .email(command.email())
                .kyc(command.kyc())
                .address(command.address())
                .contact(command.contact())
                .phoneNumber(command.phoneNumber())
                .customerSegmentId(command.customerSegmentId())
                .build();

        AggregateLifecycle.apply(event);
    }

    /**
     * Command Handler for updating phone number
     */
    @CommandHandler
    public void handle(ChangeCustomerPhoneNumberCommand command) {

        log.info("Handling ChangeCustomerPhoneNumberCommand: {}", command);

        changePhoneNumber(command.phoneNumber());
    }

    /**
     * Domain method containing business logic
     */
    private void changePhoneNumber(String newPhoneNumber) {

        if (this.phoneNumber.equals(newPhoneNumber)) {
            throw new IllegalStateException("New phone number must be different from the current one");
        }

        CustomerPhoneNumberChangedEvent event =
                CustomerPhoneNumberChangedEvent.builder()
                        .customerId(customerId)
                        .phoneNumber(newPhoneNumber)
                        .build();

        AggregateLifecycle.apply(event);
    }

    /**
     * Validate business rules during creation
     */
    private void validateCreateCustomer(CreateCustomerCommand command) {

        if (command.customerId() == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        if (command.email() == null) {
            throw new IllegalArgumentException("Customer email cannot be null");
        }

        if (command.phoneNumber() == null || command.phoneNumber().isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
    }

    /**
     * Event sourcing handler for customer creation
     */
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {

        log.info("Event sourcing CustomerCreatedEvent: {}", event);

        this.customerId = event.customerId();
        this.name = event.name();
        this.gender = event.gender();
        this.email = event.email();
        this.dob = event.dob();
        this.kyc = event.kyc();
        this.address = event.address();
        this.contact = event.contact();
        this.customerSegmentId = event.customerSegmentId();
        this.phoneNumber = event.phoneNumber();
    }

    /**
     * Event sourcing handler for phone number update
     */
    @EventSourcingHandler
    public void on(CustomerPhoneNumberChangedEvent event) {

        log.info("Event sourcing CustomerPhoneNumberChangedEvent: {}", event);
        this.phoneNumber = event.phoneNumber();
    }
}