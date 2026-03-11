package com.ministerio.starparking.entity.subscriptionlog.dto;

import com.ministerio.starparking.common.enums.SubscriptionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SubscriptionLogCreateRequest {

    @NotNull
    private Long clientId;

    @NotNull
    private Long subscriptionId;

    @NotNull
    private OffsetDateTime startsAt;

    @NotNull
    private SubscriptionStatus subscriptionStatus;
}
