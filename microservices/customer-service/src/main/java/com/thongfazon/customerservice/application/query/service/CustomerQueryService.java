package com.thongfazon.customerservice.application.query.service;

import com.thongfazon.customerservice.application.dto.query.PagedCustomerResponse;

import java.util.List;
import java.util.UUID;


public interface CustomerQueryService {

    PagedCustomerResponse recieveAllCustomers(int page, int size);

    List<?> getCustomerHistory(UUID customerId);
}
