package com.ministerio.starparking.parkinguse.repository;

import com.ministerio.starparking.parkinguse.model.ParkingUse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingUseRepository extends JpaRepository<ParkingUse, Long> {
}
