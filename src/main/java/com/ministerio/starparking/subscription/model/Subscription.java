package com.ministerio.starparking.subscription.model;

import com.ministerio.starparking.subscriptionlog.model.SubscriptionLog;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 256)
    private String description;

    @Column(nullable = false, check = @CheckConstraint(constraint = "price >= 0"))
    private BigDecimal price;

    @Column(nullable = false, check = @CheckConstraint(constraint = "day_duration >= 0"))
    private BigDecimal dayDuration;

    @Column(nullable = false)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "subscription")
    private List<SubscriptionLog> subscriptionLogs;
}
