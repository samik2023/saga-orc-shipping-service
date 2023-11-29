package com.bank.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SAGA_SHIPMENT_JPA")
public class SagaShipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackingId;

    private Long orderId;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;
}


