package com.ministerio.starparking.subscriptionlog.dto;

import com.ministerio.starparking.common.enums.SubscriptionStatus;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class SubscriptionLogResponse {
    private Long id;
    private Long clientId;
    private String clientName;
    private Long subscriptionId;
    private String subscriptionName;
    private OffsetDateTime startsAt;
    private OffsetDateTime endsAt;
    private SubscriptionStatus subscriptionStatus;
    private boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
