package com.ministerio.starparking.entity.parkingspot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParkingSpotUpdateRequest {

    @NotBlank(message = "El campo identificador de espacio no puede estar vacío")
    @Size(max = 32, message = "El campo identificador de espacio no puede superar los 32 caracteres")
    private String spotIdentifier;

    private Long vehicleId;
}
