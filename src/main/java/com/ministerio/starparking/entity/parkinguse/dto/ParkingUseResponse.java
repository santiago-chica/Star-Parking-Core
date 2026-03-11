package com.ministerio.starparking.entity.parkinguse.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class ParkingUseResponse {
    private Long id;
    private VehicleInfo vehicle;
    private ParkingSpotInfo parkingSpot;
    private OffsetDateTime entryTime;
    private OffsetDateTime exitTime;
    private Integer stayMinutes;
    private BillInfo bill;

    @Data
    @Builder
    public static class VehicleInfo {
        private Long id;
        private String plate;
        private String model;
        private String brand;
    }

    @Data
    @Builder
    public static class ParkingSpotInfo {
        private Long id;
        private String spotIdentifier;
    }

    @Data
    @Builder
    public static class BillInfo {
        private Long id;
        private BillStatus billStatus;
        private BigDecimal total;
    }
}
