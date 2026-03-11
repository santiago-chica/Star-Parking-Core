package com.ministerio.starparking.entity.subscription.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SubscriptionUpdateRequest {

    @Size(max = 32)
    private String name;

    @Size(max = 256)
    private String description;

    @DecimalMin("0.0")
    private BigDecimal price;

    @DecimalMin("0.0")
    private BigDecimal dayDuration;

    private Boolean isActive;
}
