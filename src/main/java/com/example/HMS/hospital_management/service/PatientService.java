package com.example.HMS.hospital_management.service;


import com.example.HMS.hospital_management.dto.PatientDTO;
import com.example.HMS.hospital_management.entity.Patient;
import com.example.HMS.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public PatientDTO createPatient(Patient patient) {
        return convertToDTO(patientRepository.save(patient));
    }

    public PatientDTO updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(patient -> {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setContact(patientDetails.getContact());
            patient.setAddress(patientDetails.getAddress());
            return convertToDTO(patientRepository.save(patient));
        }).orElse(null);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientDTO convertToDTO(Patient patient) {
        return new PatientDTO(patient.getId(), patient.getName(), patient.getAge(), patient.getGender(), patient.getContact(), patient.getAddress(), patient.getCreatedAt());
    }
}
