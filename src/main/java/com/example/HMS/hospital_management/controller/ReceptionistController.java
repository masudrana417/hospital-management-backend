package com.example.HMS.hospital_management.controller;


import com.example.HMS.hospital_management.dto.ReceptionistDTO;
import com.example.HMS.hospital_management.entity.Receptionist;
import com.example.HMS.hospital_management.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;

    @GetMapping
    public List<ReceptionistDTO> getAllReceptionists() {
        return receptionistService.getAllReceptionists();
    }

    @GetMapping("/{id}")
    public ReceptionistDTO getReceptionistById(@PathVariable Long id) {
        return receptionistService.getReceptionistById(id);
    }

    @PostMapping
    public ReceptionistDTO createReceptionist(@RequestBody Receptionist receptionist) {
        return receptionistService.createReceptionist(receptionist);
    }

    @DeleteMapping("/{id}")
    public void deleteReceptionist(@PathVariable Long id) {
        receptionistService.deleteReceptionist(id);
    }
}