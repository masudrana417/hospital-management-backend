package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.entity.Payment;
import com.example.HMS.hospital_management.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment processPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
