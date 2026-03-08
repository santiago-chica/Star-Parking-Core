package com.ministerio.starparking.parkingspot.model;

import com.ministerio.starparking.parkinguse.model.ParkingUse;
import com.ministerio.starparking.vehicle.model.Vehicle;
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
@Table(name = "parking_spot")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 32)
    private String spotIdentifier;

    @OneToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "parkingSpot", orphanRemoval = true, cascade = CascadeType.ALL)
    List<ParkingUse> parkingUses;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updatedAt;
}
