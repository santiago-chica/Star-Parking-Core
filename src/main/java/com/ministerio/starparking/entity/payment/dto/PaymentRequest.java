package com.ministerio.starparking.entity.payment.dto;

import com.ministerio.starparking.common.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

    @Size(max = 64)
    private String paymentReference;
}
