package com.example.HMS.hospital_management.controller;

import com.example.HMS.hospital_management.entity.Medicine;
import com.example.HMS.hospital_management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add")
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    @GetMapping("/list")
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }
}