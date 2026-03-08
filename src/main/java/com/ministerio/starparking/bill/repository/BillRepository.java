package com.ministerio.starparking.bill.repository;

import com.ministerio.starparking.bill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
