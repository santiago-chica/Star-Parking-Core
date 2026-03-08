package com.ministerio.starparking.entity.subscriptionlog.model;

import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.common.enums.SubscriptionStatus;
import com.ministerio.starparking.entity.subscription.model.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "subscription_log")
public class SubscriptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @Column(nullable = false)
    private OffsetDateTime startsAt = OffsetDateTime.now();
    private OffsetDateTime endsAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus subscriptionStatus;

    public boolean isActive() {
        OffsetDateTime now = OffsetDateTime.now();
        boolean withinTimeRange = (startsAt.isBefore(now) || startsAt.isEqual(now))
                && (endsAt == null || endsAt.isAfter(now));

        return subscriptionStatus == SubscriptionStatus.ACTIVE && withinTimeRange;
    }

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updatedAt;
}
