package com.thongfazon.customerservice.data.entity;

import com.thongfazon.customerservice.domain.valueobject.CustomerEmail;
import com.thongfazon.customerservice.domain.valueobject.CustomerGender;
import com.thongfazon.customerservice.domain.valueobject.CustomerName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    private UUID customerId;

    @Embedded
    private CustomerName name;

    @Embedded
    private CustomerEmail email;

    private LocalDate dob;

    private String phoneNumber;

    private CustomerGender gender;



    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private KycEntity kyc;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private ContactEntity contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "segment_id")
    private CustomerSegmentEntity customerSegment;

}
