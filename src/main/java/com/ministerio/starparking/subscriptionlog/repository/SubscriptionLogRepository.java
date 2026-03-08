package com.ministerio.starparking.subscriptionlog.repository;

import com.ministerio.starparking.subscriptionlog.model.SubscriptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionLogRepository extends JpaRepository<SubscriptionLog, Long> {
}
