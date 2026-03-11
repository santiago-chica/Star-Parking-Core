package com.ministerio.starparking.entity.payment.dto;

import com.ministerio.starparking.common.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentUpdateRequest {

    @NotNull
    private PaymentMethod paymentMethod;

    @Size(max = 64)
    private String paymentReference;
}
