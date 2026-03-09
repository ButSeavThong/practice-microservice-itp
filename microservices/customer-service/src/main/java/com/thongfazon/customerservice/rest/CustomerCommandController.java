package com.thongfazon.customerservice.rest;

import com.thongfazon.customerservice.application.command.CustomerService;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerRequest;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerResponse;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberRequest;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerCommandController {
    private final CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }


    @PutMapping("/{customerId}")
    public ChangePhoneNumberResponse changePhoneNumber(
            @Valid @RequestBody ChangePhoneNumberRequest request,
            @PathVariable("customerId") UUID customerIdd
    ) {
        return customerService.changePhoneNumber(customerIdd, request);
    }
}
