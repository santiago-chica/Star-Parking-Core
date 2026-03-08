package com.ministerio.starparking.vehicle.repository;

import com.ministerio.starparking.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
