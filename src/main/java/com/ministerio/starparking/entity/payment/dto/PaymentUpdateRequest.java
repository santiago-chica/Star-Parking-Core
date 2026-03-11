package com.ministerio.starparking.entity.payment.dto;

import com.ministerio.starparking.common.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentUpdateRequest {

    @NotNull(message = "El campo método de pago es obligatorio")
    private PaymentMethod paymentMethod;

    @Size(max = 64, message = "El campo referencia de pago no puede superar los 64 caracteres")
    private String paymentReference;
}
