package com.thongfazon.customerservice.application.query.handler;

import com.thongfazon.customerservice.application.dto.query.GetCustomerQuery;
import com.thongfazon.customerservice.application.dto.query.PagedCustomerResponse;
import com.thongfazon.customerservice.application.mapper.CustomerApplicationMapper;
import com.thongfazon.customerservice.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class CustomerQueryHandler {

    @Qualifier("customerApplicationMapper")
    private  final CustomerApplicationMapper mapper;
    private final CustomerRepository customerRepository;

    @QueryHandler
    public PagedCustomerResponse handle(GetCustomerQuery query) {
        log.info("Handling GetCustomerQuery: page={}, size={}", query.page(), query.size());

        PageRequest pageable = PageRequest.of(query.page(), query.size());

        return PagedCustomerResponse.from(
                customerRepository.findAll(pageable)
                        .map(mapper::toCustomerQueryResponse)
        );
    }


}