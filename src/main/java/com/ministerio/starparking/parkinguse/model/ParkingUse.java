package com.ministerio.starparking.parkinguse.model;

import com.ministerio.starparking.bill.model.Bill;
import com.ministerio.starparking.parkingspot.model.ParkingSpot;
import com.ministerio.starparking.vehicle.model.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "parking_use")
public class ParkingUse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicleId", nullable = false)
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "parkingSpotId", nullable = false)
    private ParkingSpot parkingSpot;

    @Column(nullable = false)
    private OffsetDateTime entryTime;
    @Column(nullable = false)
    private OffsetDateTime exitTime;

    @Column(
            nullable = false,
            insertable = false,
            updatable = false,
            columnDefinition = "INT GENERATED ALWAYS AS (EXTRACT(EPOCH FROM (exit_time - entry_time)) / 60) STORED"
    )
    private Integer stayMinutes;

    private Bill bill;


}
