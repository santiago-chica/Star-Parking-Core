package com.ministerio.starparking.entity.vehiclecolor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleColorCreateRequest {

    @NotBlank(message = "El campo nombre del color no puede estar vacío")
    @Size(max = 50, message = "El campo nombre del color no puede superar los 50 caracteres")
    private String colorName;

    @NotBlank(message = "El campo código hexadecimal no puede estar vacío")
    @Pattern(regexp = "^#([A-Fa-f0-9]{6})$", message = "El campo código hexadecimal debe ser un color hexadecimal válido (ej. #FF0000)")
    private String hexCode;
}
