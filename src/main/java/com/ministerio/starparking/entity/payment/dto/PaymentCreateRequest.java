package com.ministerio.starparking.entity.payment.dto;

import com.ministerio.starparking.common.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentCreateRequest {

    @NotNull(message = "El campo monto es obligatorio")
    @DecimalMin(value = "0.00", inclusive = true, message = "El campo monto debe ser mayor o igual a 0.00")
    @Digits(integer = 10, fraction = 2, message = "El campo monto debe tener máximo 10 dígitos enteros y 2 decimales")
    private BigDecimal amount;

    @NotNull(message = "El campo método de pago es obligatorio")
    private PaymentMethod paymentMethod;

    @Size(max = 64, message = "El campo referencia de pago no puede superar los 64 caracteres")
    private String paymentReference;

    private Long billId;
}
