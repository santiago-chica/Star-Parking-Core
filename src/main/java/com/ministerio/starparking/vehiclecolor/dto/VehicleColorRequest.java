package com.ministerio.starparking.vehiclecolor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleColorRequest {

    @NotBlank
    @Size(max = 50)
    private String colorName;

    @NotBlank
    @Pattern(regexp = "^#([A-Fa-f0-9]{6})$", message = "hexCode must be a valid hex color (e.g. #FF0000)")
    private String hexCode;
}
