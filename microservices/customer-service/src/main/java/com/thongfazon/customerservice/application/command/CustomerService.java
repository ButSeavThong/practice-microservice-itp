package com.thongfazon.customerservice.application.command;

import com.thongfazon.customerservice.application.dto.create.CreateCustomerRequest;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerResponse;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberRequest;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberResponse;

import java.util.UUID;

public interface CustomerService {

    ChangePhoneNumberResponse changePhoneNumber(UUID customerId, ChangePhoneNumberRequest request);

    CreateCustomerResponse createCustomer(CreateCustomerRequest request);
}
