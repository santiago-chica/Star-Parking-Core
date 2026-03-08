package com.ministerio.starparking.entity.parkingspot.repository;

import com.ministerio.starparking.entity.parkingspot.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
}
