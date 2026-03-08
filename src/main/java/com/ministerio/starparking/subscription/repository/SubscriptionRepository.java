package com.ministerio.starparking.subscription.repository;

import com.ministerio.starparking.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
