package com.thongfazon.customerservice.application.mapper;

import com.thong.common.domain.valueobject.CustomerId;
import com.thong.common.domain.valueobject.CustomerSegmentId;
import com.thongfazon.customerservice.application.dto.create.CreateCustomerRequest;
import com.thongfazon.customerservice.application.dto.query.CustomerQueryResponse;
import com.thongfazon.customerservice.application.dto.query.CustomerSegmentResponse;
import com.thongfazon.customerservice.application.dto.update.ChangePhoneNumberRequest;
import com.thongfazon.customerservice.data.entity.AddressEntity;
import com.thongfazon.customerservice.data.entity.ContactEntity;
import com.thongfazon.customerservice.data.entity.CustomerEntity;
import com.thongfazon.customerservice.data.entity.CustomerSegmentEntity;
import com.thongfazon.customerservice.data.entity.KycEntity;
import com.thongfazon.customerservice.domain.command.ChangeCustomerPhoneNumberCommand;
import com.thongfazon.customerservice.domain.command.CreateCustomerCommand;
import com.thongfazon.customerservice.domain.event.CustomerCreatedEvent;
import com.thongfazon.customerservice.domain.valueobject.Address;
import com.thongfazon.customerservice.domain.valueobject.Contact;
import com.thongfazon.customerservice.domain.valueobject.CustomerEmail;
import com.thongfazon.customerservice.domain.valueobject.CustomerGender;
import com.thongfazon.customerservice.domain.valueobject.CustomerName;
import com.thongfazon.customerservice.domain.valueobject.Kyc;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-09T01:28:16+0700",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.3.0.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class CustomerApplicationMapperImpl implements CustomerApplicationMapper {

    @Override
    public CreateCustomerCommand createCustomerRequestTocreateCustomerCommand(CustomerId customerId, CreateCustomerRequest createCustomerRequest) {
        if ( customerId == null && createCustomerRequest == null ) {
            return null;
        }

        CustomerName name = null;
        CustomerGender gender = null;
        LocalDate dob = null;
        String phoneNumber = null;
        CustomerEmail email = null;
        Contact contact = null;
        Address address = null;
        Kyc kyc = null;
        CustomerSegmentId customerSegmentId = null;
        if ( createCustomerRequest != null ) {
            name = createCustomerRequest.name();
            gender = createCustomerRequest.gender();
            dob = createCustomerRequest.dob();
            phoneNumber = createCustomerRequest.phoneNumber();
            email = createCustomerRequest.email();
            contact = createCustomerRequest.contact();
            address = createCustomerRequest.address();
            kyc = createCustomerRequest.kyc();
            customerSegmentId = createCustomerRequest.customerSegmentId();
        }
        CustomerId customerId1 = null;
        customerId1 = customerId;

        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand( customerId1, name, gender, dob, phoneNumber, email, contact, address, kyc, customerSegmentId );

        return createCustomerCommand;
    }

    @Override
    public ChangeCustomerPhoneNumberCommand changePhoneNumberRequestToChangeCustomerPhoneNumberCommand(ChangePhoneNumberRequest changePhoneNumberRequest) {
        if ( changePhoneNumberRequest == null ) {
            return null;
        }

        ChangeCustomerPhoneNumberCommand.ChangeCustomerPhoneNumberCommandBuilder changeCustomerPhoneNumberCommand = ChangeCustomerPhoneNumberCommand.builder();

        changeCustomerPhoneNumberCommand.phoneNumber( changePhoneNumberRequest.phoneNumber() );

        return changeCustomerPhoneNumberCommand.build();
    }

    @Override
    public CustomerEntity customerCreatedEventToCustomerEntity(CustomerCreatedEvent customerCreatedEvent) {
        if ( customerCreatedEvent == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId( customerCreatedEventCustomerIdValue( customerCreatedEvent ) );
        customerEntity.setName( customerCreatedEvent.name() );
        customerEntity.setEmail( customerCreatedEvent.email() );
        customerEntity.setDob( customerCreatedEvent.dob() );
        customerEntity.setPhoneNumber( customerCreatedEvent.phoneNumber() );
        customerEntity.setGender( customerCreatedEvent.gender() );
        customerEntity.setKyc( kycToKycEntity( customerCreatedEvent.kyc() ) );
        customerEntity.setAddress( addressToAddressEntity( customerCreatedEvent.address() ) );
        customerEntity.setContact( contactToContactEntity( customerCreatedEvent.contact() ) );

        return customerEntity;
    }

    @Override
    public CustomerQueryResponse toCustomerQueryResponse(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        UUID customerId = null;
        CustomerName name = null;
        CustomerEmail email = null;
        CustomerGender gender = null;
        LocalDate dob = null;
        Kyc kyc = null;
        Address address = null;
        Contact contact = null;
        String phoneNumber = null;
        CustomerSegmentResponse customerSegment = null;

        customerId = customerEntity.getCustomerId();
        name = customerEntity.getName();
        email = customerEntity.getEmail();
        gender = customerEntity.getGender();
        dob = customerEntity.getDob();
        kyc = kycEntityToKyc( customerEntity.getKyc() );
        address = addressEntityToAddress( customerEntity.getAddress() );
        contact = contactEntityToContact( customerEntity.getContact() );
        phoneNumber = customerEntity.getPhoneNumber();
        customerSegment = customerSegmentEntityToCustomerSegmentResponse( customerEntity.getCustomerSegment() );

        CustomerQueryResponse customerQueryResponse = new CustomerQueryResponse( customerId, name, email, gender, dob, kyc, address, contact, phoneNumber, customerSegment );

        return customerQueryResponse;
    }

    private UUID customerCreatedEventCustomerIdValue(CustomerCreatedEvent customerCreatedEvent) {
        CustomerId customerId = customerCreatedEvent.customerId();
        if ( customerId == null ) {
            return null;
        }
        return customerId.value();
    }

    protected KycEntity kycToKycEntity(Kyc kyc) {
        if ( kyc == null ) {
            return null;
        }

        KycEntity kycEntity = new KycEntity();

        kycEntity.setKycId( kyc.kycId() );
        kycEntity.setKycType( kyc.kycType() );
        kycEntity.setKycNumber( kyc.kycNumber() );

        return kycEntity;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAddressId( address.addressId() );
        addressEntity.setLine( address.line() );
        addressEntity.setCity( address.city() );
        addressEntity.setCountry( address.country() );
        addressEntity.setZipCode( address.zipCode() );

        return addressEntity;
    }

    protected ContactEntity contactToContactEntity(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setContactId( contact.contactId() );
        contactEntity.setType( contact.type() );
        contactEntity.setPhoneNumber( contact.phoneNumber() );

        return contactEntity;
    }

    protected Kyc kycEntityToKyc(KycEntity kycEntity) {
        if ( kycEntity == null ) {
            return null;
        }

        UUID kycId = null;
        String kycType = null;
        String kycNumber = null;

        kycId = kycEntity.getKycId();
        kycType = kycEntity.getKycType();
        kycNumber = kycEntity.getKycNumber();

        Kyc kyc = new Kyc( kycId, kycType, kycNumber );

        return kyc;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        UUID addressId = null;
        String line = null;
        String city = null;
        String country = null;
        String zipCode = null;

        addressId = addressEntity.getAddressId();
        line = addressEntity.getLine();
        city = addressEntity.getCity();
        country = addressEntity.getCountry();
        zipCode = addressEntity.getZipCode();

        Address address = new Address( addressId, line, city, country, zipCode );

        return address;
    }

    protected Contact contactEntityToContact(ContactEntity contactEntity) {
        if ( contactEntity == null ) {
            return null;
        }

        UUID contactId = null;
        String type = null;
        String phoneNumber = null;

        contactId = contactEntity.getContactId();
        type = contactEntity.getType();
        phoneNumber = contactEntity.getPhoneNumber();

        Contact contact = new Contact( contactId, type, phoneNumber );

        return contact;
    }

    protected CustomerSegmentResponse customerSegmentEntityToCustomerSegmentResponse(CustomerSegmentEntity customerSegmentEntity) {
        if ( customerSegmentEntity == null ) {
            return null;
        }

        String customerSegmentId = null;
        String customerSegmentType = null;

        if ( customerSegmentEntity.getCustomerSegmentId() != null ) {
            customerSegmentId = customerSegmentEntity.getCustomerSegmentId().toString();
        }
        if ( customerSegmentEntity.getCustomerSegmentType() != null ) {
            customerSegmentType = customerSegmentEntity.getCustomerSegmentType().name();
        }

        CustomerSegmentResponse customerSegmentResponse = new CustomerSegmentResponse( customerSegmentId, customerSegmentType );

        return customerSegmentResponse;
    }
}
