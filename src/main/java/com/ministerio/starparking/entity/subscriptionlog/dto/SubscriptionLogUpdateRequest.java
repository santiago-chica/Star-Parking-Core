package com.ministerio.starparking.entity.subscriptionlog.dto;

import com.ministerio.starparking.common.enums.SubscriptionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SubscriptionLogUpdateRequest {

    private OffsetDateTime endsAt;

    @NotNull(message = "El campo estado de suscripción es obligatorio")
    private SubscriptionStatus subscriptionStatus;
}
