package com.thongfazon.customerservice.application.query.service;

import com.thongfazon.customerservice.application.dto.query.GetCustomerQuery;
import com.thongfazon.customerservice.application.dto.query.PagedCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final EventStore eventStore;
    private final QueryGateway queryGateway;

    @Override
    public PagedCustomerResponse recieveAllCustomers(int page, int size) {
        return queryGateway.query(
                new GetCustomerQuery(page, size),
                ResponseTypes.instanceOf(PagedCustomerResponse.class)
        ).join();
    }

    @Override
    public List<?> getCustomerHistory(UUID customerId) {
        return eventStore.readEvents(customerId.toString())
                .asStream()
                .map(Message::getPayload)
                .toList();
    }
}