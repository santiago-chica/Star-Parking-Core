package com.ministerio.starparking.vehicle.model;

import com.ministerio.starparking.client.model.Client;
import com.ministerio.starparking.parkingspot.model.ParkingSpot;
import com.ministerio.starparking.parkinguse.model.ParkingUse;
import com.ministerio.starparking.vehiclecolor.model.VehicleColor;
import com.ministerio.starparking.vehicletype.model.VehicleType;
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
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "vehicle", cascade = CascadeType.ALL)
    List<ParkingUse> parkingUses;

}
