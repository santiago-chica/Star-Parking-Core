package com.ministerio.starparking.entity.vehiclecolor.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleColorUpdateRequest {

    @Size(max = 50, message = "El campo nombre del color no puede superar los 50 caracteres")
    private String colorName;

    @Pattern(regexp = "^#([A-Fa-f0-9]{6})$", message = "El campo código hexadecimal debe ser un color hexadecimal válido (ej. #FF0000)")
    private String hexCode;
}
