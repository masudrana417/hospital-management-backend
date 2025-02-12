package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
