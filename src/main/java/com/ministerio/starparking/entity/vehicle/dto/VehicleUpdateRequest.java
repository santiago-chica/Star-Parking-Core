package com.ministerio.starparking.entity.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleUpdateRequest {

    @NotBlank
    @Size(max = 16)
    private String plate;

    private Long clientId;

    private Long vehicleTypeId;

    private Long vehicleColorId;

    @Size(max = 32)
    private String model;

    @Size(max = 32)
    private String brand;
}
