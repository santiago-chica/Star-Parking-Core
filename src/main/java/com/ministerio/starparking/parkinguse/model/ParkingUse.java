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
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "parking_spot_id", nullable = false)
    private ParkingSpot parkingSpot;

    @Column(nullable = false)
    private OffsetDateTime entryTime;
    @Column(nullable = false)
    private OffsetDateTime exitTime;

    @Column(
            insertable = false,
            updatable = false,
            columnDefinition = "INT AS (TIMESTAMPDIFF(MINUTE, entry_time, exit_time)) STORED"
    )
    private Integer stayMinutes;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;


}
