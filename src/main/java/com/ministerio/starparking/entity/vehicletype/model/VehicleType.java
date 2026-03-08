package com.ministerio.starparking.entity.vehicletype.model;

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
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String name;
    @Column(length = 128)
    private String description;

    @Column(nullable = false, check = @CheckConstraint(constraint = "cost_per_minute >= 0"))
    private Float costPerMinute;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "vehicleType", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
