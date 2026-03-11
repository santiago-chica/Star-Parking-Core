package com.ministerio.starparking.entity.parkingspot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParkingSpotCreateRequest {

    @NotBlank
    @Size(max = 32)
    private String spotIdentifier;

    private Long vehicleId;
}
