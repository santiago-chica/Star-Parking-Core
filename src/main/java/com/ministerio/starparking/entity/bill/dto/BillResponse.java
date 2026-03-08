package com.ministerio.starparking.entity.bill.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class BillResponse {
    private Long id;
    private Long clientId;
    private String clientName;
    private Long paymentId;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal total;
    private BillStatus billStatus;
    private String notes;
    private OffsetDateTime createdAt;
}
