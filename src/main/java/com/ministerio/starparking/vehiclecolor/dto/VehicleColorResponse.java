package com.ministerio.starparking.vehiclecolor.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleColorResponse {
    private Long id;
    private String colorName;
    private String hexCode;
}
