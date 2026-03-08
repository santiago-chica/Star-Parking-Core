package com.ministerio.starparking.bill.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillRequest {

    @NotNull
    private Long clientId;

    private Long paymentId;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal subtotal;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private BigDecimal discount;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private BigDecimal tax;

    @NotNull
    private BillStatus billStatus;

    @Size(max = 100)
    private String notes;
}
