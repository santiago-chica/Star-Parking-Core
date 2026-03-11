package com.ministerio.starparking.entity.parkinguse.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ParkingUseUpdateRequest {

    private OffsetDateTime exitTime;

    private Long billId;
}
