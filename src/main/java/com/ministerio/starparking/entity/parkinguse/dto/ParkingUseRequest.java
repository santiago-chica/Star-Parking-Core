package com.ministerio.starparking.entity.parkinguse.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ParkingUseRequest {

    @NotNull
    private Long vehicleId;

    @NotNull
    private Long parkingSpotId;

    @NotNull
    private OffsetDateTime entryTime;

    @NotNull
    private OffsetDateTime exitTime;

    private Long billId;
}
