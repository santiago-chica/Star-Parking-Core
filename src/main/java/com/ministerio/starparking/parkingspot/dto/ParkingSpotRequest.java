package com.ministerio.starparking.parkingspot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParkingSpotRequest {

    @NotBlank
    @Size(max = 32)
    private String spotIdentifier;

    private Long vehicleId;
}
