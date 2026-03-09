package com.thongfazon.customerservice.data.entity;

import com.thongfazon.customerservice.domain.valueobject.CustomerSegmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer_segments")
public class CustomerSegmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerSegmentId;

    private CustomerSegmentType customerSegmentType;

    @OneToMany(mappedBy = "customerSegment", cascade = CascadeType.ALL)
    private List<CustomerEntity> customer;

}
