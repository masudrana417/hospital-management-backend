package com.example.HMS.hospital_management.controller;

import com.example.HMS.hospital_management.entity.LabTest;
import com.example.HMS.hospital_management.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController {
    @Autowired
    private LabTestService labTestService;

    @GetMapping
    public List<LabTest> getAllLabTests() {
        return labTestService.getAllLabTests();
    }

    @GetMapping("/{id}")
    public LabTest getLabTestById(@PathVariable Long id) {
        return labTestService.getLabTestById(id);
    }

    @PostMapping
    public LabTest createLabTest(@RequestBody LabTest labTest) {
        return labTestService.createLabTest(labTest);
    }

    @PutMapping("/{id}")
    public LabTest updateLabTest(@PathVariable Long id, @RequestBody LabTest updatedLabTest) {
        return labTestService.updateLabTest(id, updatedLabTest);
    }

    @DeleteMapping("/{id}")
    public void deleteLabTest(@PathVariable Long id) {
        labTestService.deleteLabTest(id);
    }
}
