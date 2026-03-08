package com.ministerio.starparking.entity.subscriptionlog.repository;

import com.ministerio.starparking.entity.subscriptionlog.model.SubscriptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionLogRepository extends JpaRepository<SubscriptionLog, Long> {
}
