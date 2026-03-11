package com.ministerio.starparking.entity.subscriptionlog.dto;

import com.ministerio.starparking.common.enums.SubscriptionStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class SubscriptionLogResponse {
    private Long id;
    private Long clientId;
    private String clientName;
    private SubscriptionInfo subscription;
    private OffsetDateTime startsAt;
    private OffsetDateTime endsAt;
    private SubscriptionStatus subscriptionStatus;
    private boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @Data
    @Builder
    public static class SubscriptionInfo {
        private Long id;
        private String name;
        private BigDecimal price;
        private BigDecimal dayDuration;
    }
}
