package com.ministerio.starparking.subscription.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SubscriptionResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal dayDuration;
    private Boolean isActive;
}
