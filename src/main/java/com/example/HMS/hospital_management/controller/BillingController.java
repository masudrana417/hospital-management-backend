package com.example.HMS.hospital_management.controller;

import com.example.HMS.hospital_management.entity.Billing;
import com.example.HMS.hospital_management.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;

    @GetMapping
    public List<Billing> getAllBills() {
        return billingService.getAllBills();
    }

    @PostMapping
    public Billing createBill(@RequestBody Billing billing) {
        return billingService.createBill(billing);
    }
}
