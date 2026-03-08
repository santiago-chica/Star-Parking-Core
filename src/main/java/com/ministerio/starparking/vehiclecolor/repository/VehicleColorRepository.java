package com.ministerio.starparking.vehiclecolor.repository;

import com.ministerio.starparking.vehiclecolor.model.VehicleColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleColorRepository extends JpaRepository<VehicleColor, Long> {
}
