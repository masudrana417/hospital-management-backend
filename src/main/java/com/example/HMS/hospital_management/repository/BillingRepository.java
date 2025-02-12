package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
