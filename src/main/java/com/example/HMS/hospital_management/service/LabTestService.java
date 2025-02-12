package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.entity.LabTest;
import com.example.HMS.hospital_management.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabTestService {
    @Autowired
    private LabTestRepository labTestRepository;

    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }

    public LabTest getLabTestById(Long id) {
        return labTestRepository.findById(id).orElse(null);
    }

    public LabTest createLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }

    public LabTest updateLabTest(Long id, LabTest updatedLabTest) {
        Optional<LabTest> existingTest = labTestRepository.findById(id);
        if (existingTest.isPresent()) {
            LabTest test = existingTest.get();
            test.setTestName(updatedLabTest.getTestName());
            test.setDescription(updatedLabTest.getDescription());
            test.setPrice(updatedLabTest.getPrice());
            test.setStatus(updatedLabTest.getStatus());
            return labTestRepository.save(test);
        }
        return null;
    }

    public void deleteLabTest(Long id) {
        labTestRepository.deleteById(id);
    }
}
