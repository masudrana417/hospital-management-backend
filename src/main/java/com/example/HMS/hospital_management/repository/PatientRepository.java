package com.example.HMS.hospital_management.repository;


import com.example.HMS.hospital_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

