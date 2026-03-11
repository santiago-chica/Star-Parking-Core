package com.ministerio.starparking.entity.vehicle.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class VehicleResponse {
    private Long id;
    private String plate;
    private ClientInfo client;
    private VehicleTypeInfo vehicleType;
    private VehicleColorInfo vehicleColor;
    private String model;
    private String brand;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @Data
    @Builder
    public static class ClientInfo {
        private Long id;
        private String fullName;
        private Long documentNumber;
    }

    @Data
    @Builder
    public static class VehicleTypeInfo {
        private Long id;
        private String name;
        private Float costPerMinute;
    }

    @Data
    @Builder
    public static class VehicleColorInfo {
        private Long id;
        private String colorName;
        private String hexCode;
    }
}
