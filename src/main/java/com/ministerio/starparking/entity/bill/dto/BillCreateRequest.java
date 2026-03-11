package com.ministerio.starparking.entity.bill.dto;

import com.ministerio.starparking.common.enums.BillStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillCreateRequest {

    @NotNull(message = "El campo ID del cliente es obligatorio")
    private Long clientId;

    private Long paymentId;

    @NotNull(message = "El campo subtotal es obligatorio")
    @DecimalMin(value = "0.00", inclusive = true, message = "El campo subtotal debe ser mayor o igual a 0.00")
    @Digits(integer = 10, fraction = 2, message = "El campo subtotal debe tener máximo 10 dígitos enteros y 2 decimales")
    private BigDecimal subtotal;

    @NotNull(message = "El campo descuento es obligatorio")
    @DecimalMin(value = "0.00", inclusive = true, message = "El campo descuento debe ser mayor o igual a 0.00")
    @DecimalMax(value = "1.00", inclusive = true, message = "El campo descuento debe ser menor o igual a 1.00")
    @Digits(integer = 1, fraction = 4, message = "El campo descuento debe tener máximo 1 dígitos enteros y 4 decimales")
    private BigDecimal discount;

    @NotNull(message = "El campo impuesto es obligatorio")
    @DecimalMin(value = "0.00", inclusive = true, message = "El campo impuesto debe ser mayor o igual a 0.00")
    @DecimalMax(value = "1.00", inclusive = true, message = "El campo impuesto debe ser menor o igual a 1.00")
    @Digits(integer = 1, fraction = 4, message = "El campo impuesto debe tener máximo 1 dígitos enteros y 4 decimales")
    private BigDecimal tax;

    private BillStatus billStatus = BillStatus.PENDING;

    @Size(max = 100, message = "El campo notas no puede superar los 100 caracteres")
    private String notes;
}
