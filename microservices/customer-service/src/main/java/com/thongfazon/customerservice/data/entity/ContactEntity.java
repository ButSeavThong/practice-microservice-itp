package com.thongfazon.customerservice.data.entity;

import com.thongfazon.customerservice.data.entity.CustomerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID contactId;

    private String type;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
