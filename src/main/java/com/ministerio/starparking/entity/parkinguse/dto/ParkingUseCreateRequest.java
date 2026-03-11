package com.ministerio.starparking.entity.parkinguse.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ParkingUseCreateRequest {

    @NotNull
    private Long vehicleId;

    @NotNull
    private Long parkingSpotId;

    @NotNull
    private OffsetDateTime entryTime;

    private OffsetDateTime exitTime;

    private Long billId;
}
