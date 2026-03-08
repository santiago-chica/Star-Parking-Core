package com.ministerio.starparking.vehicletype.repository;

import com.ministerio.starparking.vehicletype.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
