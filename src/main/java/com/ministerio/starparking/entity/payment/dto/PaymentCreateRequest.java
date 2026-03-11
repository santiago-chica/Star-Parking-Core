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

    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

    @Size(max = 64)
    private String paymentReference;

    private Long billId;
}
