package com.ministerio.starparking.entity.parkinguse.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ParkingUseUpdateRequest {

    private Long vehicleId;

    private Long parkingSpotId;

    private OffsetDateTime entryTime;

    private OffsetDateTime exitTime;

    private Long billId;
}
