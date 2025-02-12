package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}