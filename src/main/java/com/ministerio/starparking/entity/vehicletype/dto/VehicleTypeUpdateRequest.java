package com.ministerio.starparking.entity.vehicletype.dto;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleTypeUpdateRequest {

    @Size(max = 32)
    private String name;

    @Size(max = 128)
    private String description;

    @PositiveOrZero
    private Float costPerMinute;
}
