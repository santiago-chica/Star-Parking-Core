package com.ministerio.starparking.entity.subscription.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SubscriptionCreateRequest {

    @NotBlank(message = "El campo nombre no puede estar vacío")
    @Size(max = 32, message = "El campo nombre no puede superar los 32 caracteres")
    private String name;

    @NotBlank(message = "El campo descripción no puede estar vacío")
    @Size(max = 256, message = "El campo descripción no puede superar los 256 caracteres")
    private String description;

    @NotNull(message = "El campo precio es obligatorio")
    @DecimalMin(value = "0.0", message = "El campo precio debe ser mayor o igual a 0.0")
    private BigDecimal price;

    @NotNull(message = "El campo duración en días es obligatorio")
    @DecimalMin(value = "0.0", message = "El campo duración en días debe ser mayor o igual a 0.0")
    private BigDecimal dayDuration;

    private Boolean isActive = true;
}
