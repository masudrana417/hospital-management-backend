package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.entity.TestReport;
import com.example.HMS.hospital_management.repository.TestReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestReportService {
    @Autowired
    private TestReportRepository testReportRepository;

    public List<TestReport> getAllReports() {
        return testReportRepository.findAll();
    }

    public TestReport getReportById(Long id) {
        return testReportRepository.findById(id).orElse(null);
    }

    public TestReport createReport(TestReport report) {
        return testReportRepository.save(report);
    }

    public void deleteReport(Long id) {
        testReportRepository.deleteById(id);
    }
}
