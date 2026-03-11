package com.ministerio.starparking.entity.vehicletype.dto;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleTypeUpdateRequest {

    @Size(max = 32, message = "El campo nombre no puede superar los 32 caracteres")
    private String name;

    @Size(max = 128, message = "El campo descripción no puede superar los 128 caracteres")
    private String description;

    @PositiveOrZero(message = "El campo costo por minuto debe ser mayor o igual a cero")
    private Float costPerMinute;
}
