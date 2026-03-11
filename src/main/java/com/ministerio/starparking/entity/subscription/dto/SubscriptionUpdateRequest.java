package com.ministerio.starparking.entity.subscription.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SubscriptionUpdateRequest {

    @Size(max = 32, message = "El campo nombre no puede superar los 32 caracteres")
    private String name;

    @Size(max = 256, message = "El campo descripción no puede superar los 256 caracteres")
    private String description;

    @DecimalMin(value = "0.0", message = "El campo precio debe ser mayor o igual a 0.0")
    private BigDecimal price;

    @DecimalMin(value = "0.0", message = "El campo duración en días debe ser mayor o igual a 0.0")
    private BigDecimal dayDuration;

    private Boolean isActive;
}
