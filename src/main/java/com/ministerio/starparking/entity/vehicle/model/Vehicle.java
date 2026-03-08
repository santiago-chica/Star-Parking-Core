package com.ministerio.starparking.entity.vehicle.model;

import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.entity.parkingspot.model.ParkingSpot;
import com.ministerio.starparking.entity.parkinguse.model.ParkingUse;
import com.ministerio.starparking.entity.vehiclecolor.model.VehicleColor;
import com.ministerio.starparking.entity.vehicletype.model.VehicleType;
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
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "vehicle_color_id")
    private VehicleColor vehicleColor;

    @OneToOne(mappedBy = "vehicle")
    private ParkingSpot parkingSpot;

    @Column(length = 32)
    private String model;
    @Column(length = 32)
    private String brand;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ParkingUse> parkingUses;

}
