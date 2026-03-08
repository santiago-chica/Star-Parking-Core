package com.ministerio.starparking.entity.payment.repository;

import com.ministerio.starparking.entity.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
