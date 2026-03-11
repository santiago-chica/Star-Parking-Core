package com.ministerio.starparking.entity.activity.dto;

import com.ministerio.starparking.common.enums.ActionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActivityUpdateRequest {

    @NotNull(message = "El campo tipo de acción es obligatorio")
    private ActionType actionType;

    @Size(max = 128, message = "El campo detalle no puede superar los 128 caracteres")
    private String detail;
}
