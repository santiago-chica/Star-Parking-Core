package com.ministerio.starparking.entity.subscription.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SubscriptionCreateRequest {

    @NotBlank
    @Size(max = 32)
    private String name;

    @NotBlank
    @Size(max = 256)
    private String description;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal dayDuration;

    private Boolean isActive = true;
}
