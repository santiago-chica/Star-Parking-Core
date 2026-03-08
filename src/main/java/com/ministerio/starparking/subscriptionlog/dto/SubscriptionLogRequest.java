package com.ministerio.starparking.subscriptionlog.dto;

import com.ministerio.starparking.common.enums.SubscriptionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SubscriptionLogRequest {

    @NotNull
    private Long clientId;

    @NotNull
    private Long subscriptionId;

    @NotNull
    private OffsetDateTime startsAt;

    private OffsetDateTime endsAt;

    @NotNull
    private SubscriptionStatus subscriptionStatus;
}
