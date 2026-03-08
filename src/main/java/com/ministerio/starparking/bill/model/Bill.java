package com.ministerio.starparking.bill.model;

import com.ministerio.starparking.client.model.Client;
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
    @JoinColumn(name = "clientId")
    private Client client;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false, check = @CheckConstraint(constraint = "subtotal >= 0"))
    private BigDecimal subtotal;

    @Column(nullable = false, check = @CheckConstraint(constraint = "discount >= 0 AND discount <= 1"))
    private BigDecimal discount;

    @Column(nullable = false, check = @CheckConstraint(constraint = "tax >= 0 AND tax <= 1"))
    private BigDecimal tax;

    @Column(
            nullable = false,
            insertable = false,
            updatable = false,
            columnDefinition = "NUMERIC GENERATED ALWAYS AS (subtotal * (1 - discount) * (1 + tax)) STORED"
    )
    private BigDecimal total;

    @Column(length = 100)
    private String notes;

}