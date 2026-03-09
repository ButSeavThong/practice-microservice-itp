package com.thongfazon.customerservice.rest;

import com.thongfazon.customerservice.application.query.service.CustomerQueryService;
import com.thongfazon.customerservice.application.dto.query.PagedCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerQueryController {
    private final CustomerQueryService customerQueryService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagedCustomerResponse createCustomer(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size

    ) {
        return customerQueryService.recieveAllCustomers(page, size);
    }

    @GetMapping("/{customerId}/history")
    public List<?> getCustomerHistory( @PathVariable  UUID customerId) {
        return customerQueryService.getCustomerHistory(customerId);
    }
}
