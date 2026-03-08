package com.ministerio.starparking.entity.bill.repository;

import com.ministerio.starparking.entity.bill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
