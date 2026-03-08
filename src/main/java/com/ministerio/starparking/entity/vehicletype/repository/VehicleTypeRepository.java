package com.ministerio.starparking.entity.vehicletype.repository;

import com.ministerio.starparking.entity.vehicletype.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
