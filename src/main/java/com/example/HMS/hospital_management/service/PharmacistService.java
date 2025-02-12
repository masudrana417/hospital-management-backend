package com.example.HMS.hospital_management.service;


import com.example.HMS.hospital_management.dto.PharmacistDTO;
import com.example.HMS.hospital_management.entity.Pharmacist;
import com.example.HMS.hospital_management.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;

    public List<PharmacistDTO> getAllPharmacists() {
        return pharmacistRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PharmacistDTO getPharmacistById(Long id) {
        return pharmacistRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public PharmacistDTO createPharmacist(Pharmacist pharmacist) {
        return convertToDTO(pharmacistRepository.save(pharmacist));
    }

    public void deletePharmacist(Long id) {
        pharmacistRepository.deleteById(id);
    }

    private PharmacistDTO convertToDTO(Pharmacist pharmacist) {
        return new PharmacistDTO(pharmacist.getId(), pharmacist.getName(), pharmacist.getEmail(), pharmacist.getContact());
    }
}