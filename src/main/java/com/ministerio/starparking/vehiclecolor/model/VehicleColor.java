package com.ministerio.starparking.vehiclecolor.model;

import com.ministerio.starparking.vehicle.model.Vehicle;
import org.hibernate.annotations.Check;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "vehicle_color")
public class VehicleColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String colorName;

    @Column(length = 7, nullable = false, check = @CheckConstraint(constraint = "color ~ '^#([A-Fa-f0-9]{6})$'"))
    private String hexCode;

    @OneToMany(mappedBy = "vehicleColor")
    private List<Vehicle> vehicles;
}
