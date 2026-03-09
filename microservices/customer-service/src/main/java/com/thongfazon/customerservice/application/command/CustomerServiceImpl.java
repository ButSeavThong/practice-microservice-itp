package com.thongfazon.customerservice.application.command;

import com.thong.common.domain.valueobject.CustomerId;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerRequest;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerResponse;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberRequest;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberResponse;
import com.thongfazon.customerservice.application.mapper.CustomerApplicationMapper;
import com.thongfazon.customerservice.domain.command.ChangeCustomerPhoneNumberCommand;
import com.thongfazon.customerservice.domain.command.CreateCustomerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;

import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
//    @Qualifier("customerApplicationMapper")
    private final CustomerApplicationMapper customerApplicationMapper;
    private final CommandGateway commandGateway;



    @Override
    public CreateCustomerResponse createCustomer( CreateCustomerRequest request) {
        // 1. Transfer data from request to command
        CreateCustomerCommand createCustomerCommand = customerApplicationMapper
                .createCustomerRequestTocreateCustomerCommand(new CustomerId(UUID.randomUUID()),request);
        log.info("CreateCustomerCommand: {}", createCustomerCommand);

        // 2. Invoke and handle Axon command gateway ( it will return aggregate identifier
        CustomerId result = commandGateway.sendAndWait(createCustomerCommand);
        log.info("CommandGateway Result: {}", result);

        return CreateCustomerResponse.builder()
                .customerId(result)
                .message("Customer created successfully")
                .build();


    }

    @Override
    public ChangePhoneNumberResponse changePhoneNumber(UUID customerId, ChangePhoneNumberRequest request) {
        // 1. Transfer data from request to command
        ChangeCustomerPhoneNumberCommand changePhoneNumberCommand = ChangeCustomerPhoneNumberCommand.builder()
                .customerId(new CustomerId(customerId))
                .phoneNumber(request.phoneNumber())
                .build();
        log.info("ChangePhoneNumberCommand: {}", changePhoneNumberCommand);


        // will NOT return anything unless your @CommandHandler returns a value.
        commandGateway.sendAndWait(changePhoneNumberCommand);

        return ChangePhoneNumberResponse.builder()
                .customerId(changePhoneNumberCommand.customerId())
                .phoneNumber(changePhoneNumberCommand.phoneNumber())
                .message("Phone number changed successfully")
                .build();
    }
}
