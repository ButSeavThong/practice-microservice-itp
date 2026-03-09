package com.thongfazon.customerservice.application.mapper;

import com.thong.common.domain.valueobject.CustomerId;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerRequest;
import com.thongfazon.customerservice.application.dto.query.CustomerQueryResponse;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberRequest;
import com.thongfazon.customerservice.data.entity.CustomerEntity;
import com.thongfazon.customerservice.domain.command.ChangeCustomerPhoneNumberCommand;
import com.thongfazon.customerservice.domain.command.CreateCustomerCommand;
import com.thongfazon.customerservice.domain.event.CustomerCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerApplicationMapper {

    @Mapping(target = "customerId", source = "customerId")
    CreateCustomerCommand createCustomerRequestTocreateCustomerCommand(CustomerId customerId, CreateCustomerRequest createCustomerRequest);
    ChangeCustomerPhoneNumberCommand changePhoneNumberRequestToChangeCustomerPhoneNumberCommand(ChangePhoneNumberRequest changePhoneNumberRequest);

    @Mapping(target = "customerId", source = "customerId.value")
//    @Mapping(target = "phoneNumber", source = "contact.phoneNumber")
    CustomerEntity customerCreatedEventToCustomerEntity(CustomerCreatedEvent customerCreatedEvent);

   CustomerQueryResponse toCustomerQueryResponse(CustomerEntity customerEntity);

}
