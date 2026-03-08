package com.ministerio.starparking.entity.parkingspot.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class ParkingSpotResponse {
    private Long id;
    private String spotIdentifier;
    private Long vehicleId;
    private String vehiclePlate;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
