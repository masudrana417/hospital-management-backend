package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabTestRepository extends JpaRepository<LabTest, Long> {
    List<LabTest> findByPatientId(Long patientId);
    List<LabTest> findByDoctorId(Long doctorId);
}
