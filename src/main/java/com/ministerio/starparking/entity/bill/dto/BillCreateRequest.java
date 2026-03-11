package com.ministerio.starparking.entity.bill.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillCreateRequest {

    @NotNull
    private Long clientId;

    private Long paymentId;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal subtotal;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "1.00", inclusive = true)
    @Digits(integer = 1, fraction = 4)
    private BigDecimal discount;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "1.00", inclusive = true)
    @Digits(integer = 1, fraction = 4)
    private BigDecimal tax;

    private BillStatus billStatus = BillStatus.PENDING;

    @Size(max = 100)
    private String notes;
}
