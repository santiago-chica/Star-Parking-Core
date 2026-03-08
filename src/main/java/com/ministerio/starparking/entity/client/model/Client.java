package com.ministerio.starparking.entity.client.model;

import com.ministerio.starparking.entity.bill.model.Bill;
import com.ministerio.starparking.common.enums.DocumentType;
import com.ministerio.starparking.entity.subscriptionlog.model.SubscriptionLog;
import com.ministerio.starparking.entity.vehicle.model.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private DocumentType documentType;

    @Column(nullable = false, check = @CheckConstraint(constraint = "document_number > 0"))
    private Long documentNumber;

    @Column(length = 64)
    private String phoneNumber;

    @Column(length = 128, unique = true)
    private String email;

    @Column(length = 128)
    private String address;

    @Column(nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "client")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "client")
    private List<Bill> bills;

    @OneToMany(mappedBy = "client")
    private List<SubscriptionLog> subscriptionLogs;


}
