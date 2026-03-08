package com.ministerio.starparking.payment.repository;

import com.ministerio.starparking.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
