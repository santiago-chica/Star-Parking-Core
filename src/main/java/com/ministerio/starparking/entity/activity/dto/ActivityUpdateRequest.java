package com.ministerio.starparking.entity.activity.dto;

import com.ministerio.starparking.common.enums.ActionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActivityUpdateRequest {

    @NotNull
    private ActionType actionType;

    @Size(max = 128)
    private String detail;
}
