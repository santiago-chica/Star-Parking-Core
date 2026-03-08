package com.ministerio.starparking.vehicletype.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class VehicleTypeResponse {
    private Long id;
    private String name;
    private String description;
    private Float costPerMinute;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
