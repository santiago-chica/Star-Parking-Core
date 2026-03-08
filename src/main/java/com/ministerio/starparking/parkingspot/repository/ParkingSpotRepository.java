package com.ministerio.starparking.parkingspot.repository;

import com.ministerio.starparking.parkingspot.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
}
