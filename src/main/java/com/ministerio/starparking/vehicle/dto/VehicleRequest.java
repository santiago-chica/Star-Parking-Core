package com.ministerio.starparking.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleRequest {

    @NotBlank
    @Size(max = 16)
    private String plate;

    @NotNull
    private Long clientId;

    @NotNull
    private Long vehicleTypeId;

    @NotNull
    private Long vehicleColorId;

    @Size(max = 32)
    private String model;

    @Size(max = 32)
    private String brand;
}
