package com.ministerio.starparking.bill.model;

import com.ministerio.starparking.client.model.Client;
import com.ministerio.starparking.common.enums.BillStatus;
import com.ministerio.starparking.parkinguse.model.ParkingUse;
import com.ministerio.starparking.payment.model.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "payment_id", unique = true)
    private Payment payment;

    @OneToOne(mappedBy = "bill")
    private ParkingUse parkingUse;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false, check = @CheckConstraint(name = "subtotal_constraint", constraint = "subtotal >= 0"))
    private BigDecimal subtotal;

    @Column(nullable = false, check = @CheckConstraint(name = "discount_constraint", constraint = "discount >= 0 AND discount <= 1"))
    private BigDecimal discount;

    @Column(nullable = false, check = @CheckConstraint(name = "tax_constraint", constraint = "tax >= 0 AND tax <= 1"))
    private BigDecimal tax;

    @Column(
            insertable = false,
            updatable = false,
            columnDefinition = "DECIMAL(38,2) AS (subtotal * (1 - discount) * (1 + tax)) STORED"
    )
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillStatus billStatus = BillStatus.PENDING;

    @Column(length = 100)
    private String notes;

}