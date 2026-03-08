package com.ministerio.starparking.entity.parkinguse.repository;

import com.ministerio.starparking.entity.parkinguse.model.ParkingUse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingUseRepository extends JpaRepository<ParkingUse, Long> {
}
