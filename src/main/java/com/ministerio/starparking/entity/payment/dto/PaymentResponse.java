package com.ministerio.starparking.entity.payment.dto;

import com.ministerio.starparking.common.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class PaymentResponse {
    private Long id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String paymentReference;
    private Long billId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
