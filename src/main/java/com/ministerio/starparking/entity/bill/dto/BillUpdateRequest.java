package com.ministerio.starparking.entity.bill.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BillUpdateRequest {

    private Long paymentId;

    @NotNull(message = "El campo estado de la factura es obligatorio")
    private BillStatus billStatus;

    @Size(max = 100, message = "El campo notas no puede superar los 100 caracteres")
    private String notes;
}
