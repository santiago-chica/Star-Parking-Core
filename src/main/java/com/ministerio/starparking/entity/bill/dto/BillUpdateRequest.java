package com.ministerio.starparking.entity.bill.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BillUpdateRequest {

    private Long paymentId;

    @NotNull
    private BillStatus billStatus;

    @Size(max = 100)
    private String notes;
}
