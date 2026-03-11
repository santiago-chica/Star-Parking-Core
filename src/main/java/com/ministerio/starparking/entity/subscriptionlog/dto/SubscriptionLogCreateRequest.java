package com.ministerio.starparking.entity.subscriptionlog.dto;

import com.ministerio.starparking.common.enums.SubscriptionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SubscriptionLogCreateRequest {

    @NotNull(message = "El campo ID del cliente es obligatorio")
    private Long clientId;

    @NotNull(message = "El campo ID de la suscripción es obligatorio")
    private Long subscriptionId;

    @NotNull(message = "El campo fecha de inicio es obligatorio")
    private OffsetDateTime startsAt;

    @NotNull(message = "El campo estado de suscripción es obligatorio")
    private SubscriptionStatus subscriptionStatus;
}
