package com.ministerio.starparking.entity.parkinguse.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ParkingUseCreateRequest {

    @NotNull(message = "El campo ID del vehículo es obligatorio")
    private Long vehicleId;

    @NotNull(message = "El campo ID del espacio de parqueo es obligatorio")
    private Long parkingSpotId;

    @NotNull(message = "El campo hora de entrada es obligatorio")
    private OffsetDateTime entryTime;

    private OffsetDateTime exitTime;

    private Long billId;
}
