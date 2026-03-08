package com.ministerio.starparking.entity.subscription.repository;

import com.ministerio.starparking.entity.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
