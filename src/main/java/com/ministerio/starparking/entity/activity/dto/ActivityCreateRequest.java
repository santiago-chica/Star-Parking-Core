package com.ministerio.starparking.entity.activity.dto;

import com.ministerio.starparking.common.enums.ActionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActivityCreateRequest {

    @NotNull(message = "El campo ID del usuario es obligatorio")
    private Long userId;

    @NotNull(message = "El campo tipo de acción es obligatorio")
    private ActionType actionType;

    @Size(max = 128, message = "El campo detalle no puede superar los 128 caracteres")
    private String detail;

    @NotNull(message = "El campo dirección IP es obligatorio")
    @Size(max = 45, message = "El campo dirección IP no puede superar los 45 caracteres")
    private String ipAddress;
}
