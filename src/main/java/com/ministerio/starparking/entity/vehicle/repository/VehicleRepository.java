package com.ministerio.starparking.entity.vehicle.repository;

import com.ministerio.starparking.entity.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
