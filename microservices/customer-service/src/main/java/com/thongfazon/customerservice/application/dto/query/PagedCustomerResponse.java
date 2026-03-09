package com.thongfazon.customerservice.application.dto.query;

import org.springframework.data.domain.Page;
import java.util.List;

public record PagedCustomerResponse(
        List<CustomerQueryResponse> content,
        int totalPages,
        long totalElements,
        int currentPage,
        int pageSize
) {
    public static PagedCustomerResponse from(Page<CustomerQueryResponse> page) {
        return new PagedCustomerResponse(
                page.getContent(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getNumber(),
                page.getSize()
        );
    }
}