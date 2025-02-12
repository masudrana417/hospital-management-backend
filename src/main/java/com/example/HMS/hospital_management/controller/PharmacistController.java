package com.example.HMS.hospital_management.controller;


import com.example.HMS.hospital_management.dto.PharmacistDTO;
import com.example.HMS.hospital_management.entity.Pharmacist;
import com.example.HMS.hospital_management.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacist")
public class PharmacistController {
    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping
    public List<PharmacistDTO> getAllPharmacists() {
        return pharmacistService.getAllPharmacists();
    }

    @GetMapping("/{id}")
    public PharmacistDTO getPharmacistById(@PathVariable Long id) {
        return pharmacistService.getPharmacistById(id);
    }

    @PostMapping
    public PharmacistDTO createPharmacist(@RequestBody Pharmacist pharmacist) {
        return pharmacistService.createPharmacist(pharmacist);
    }

    @DeleteMapping("/{id}")
    public void deletePharmacist(@PathVariable Long id) {
        pharmacistService.deletePharmacist(id);
    }
}