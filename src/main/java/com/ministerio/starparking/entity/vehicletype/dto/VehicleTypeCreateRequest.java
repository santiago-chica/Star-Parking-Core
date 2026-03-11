package com.ministerio.starparking.entity.vehicletype.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleTypeCreateRequest {

    @NotBlank
    @Size(max = 32)
    private String name;

    @Size(max = 128)
    private String description;

    @NotNull
    @PositiveOrZero
    private Float costPerMinute;
}
