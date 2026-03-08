package com.ministerio.starparking.entity.vehicle.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class VehicleResponse {
    private Long id;
    private String plate;
    private Long clientId;
    private String clientName;
    private Long vehicleTypeId;
    private String vehicleTypeName;
    private Long vehicleColorId;
    private String vehicleColorName;
    private String model;
    private String brand;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
