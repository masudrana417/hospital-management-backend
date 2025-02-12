package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.entity.Billing;
import com.example.HMS.hospital_management.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    public Billing createBill(Billing billing) {
        return billingRepository.save(billing);
    }
}