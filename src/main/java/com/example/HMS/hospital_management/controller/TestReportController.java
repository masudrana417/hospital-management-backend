package com.example.HMS.hospital_management.controller;

import com.example.HMS.hospital_management.entity.TestReport;
import com.example.HMS.hospital_management.service.TestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-reports")
public class TestReportController {
    @Autowired
    private TestReportService testReportService;

    @GetMapping
    public List<TestReport> getAllReports() {
        return testReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public TestReport getReportById(@PathVariable Long id) {
        return testReportService.getReportById(id);
    }

    @PostMapping
    public TestReport createReport(@RequestBody TestReport report) {
        return testReportService.createReport(report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        testReportService.deleteReport(id);
    }
}
