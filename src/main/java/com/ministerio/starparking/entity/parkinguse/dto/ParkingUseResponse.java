package com.ministerio.starparking.entity.parkinguse.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class ParkingUseResponse {
    private Long id;
    private Long vehicleId;
    private String vehiclePlate;
    private Long parkingSpotId;
    private String spotIdentifier;
    private OffsetDateTime entryTime;
    private OffsetDateTime exitTime;
    private Integer stayMinutes;
    private Long billId;
}
