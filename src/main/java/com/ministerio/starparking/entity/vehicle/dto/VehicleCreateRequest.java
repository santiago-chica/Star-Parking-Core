package com.ministerio.starparking.entity.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleCreateRequest {

    @NotBlank(message = "El campo placa no puede estar vacío")
    @Size(max = 16, message = "El campo placa no puede superar los 16 caracteres")
    private String plate;

    @NotNull(message = "El campo ID del cliente es obligatorio")
    private Long clientId;

    @NotNull(message = "El campo ID del tipo de vehículo es obligatorio")
    private Long vehicleTypeId;

    @NotNull(message = "El campo ID del color de vehículo es obligatorio")
    private Long vehicleColorId;

    @Size(max = 32, message = "El campo modelo no puede superar los 32 caracteres")
    private String model;

    @Size(max = 32, message = "El campo marca no puede superar los 32 caracteres")
    private String brand;
}
