package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestReportRepository extends JpaRepository<TestReport, Long> {
    List<TestReport> findByLabTestId(Long labTestId);
}
