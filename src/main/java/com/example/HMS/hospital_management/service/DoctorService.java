package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.dto.DoctorDTO;
import com.example.HMS.hospital_management.entity.Doctor;
import com.example.HMS.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Long id) {
        return doctorRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public DoctorDTO createDoctor(Doctor doctor) {
        return convertToDTO(doctorRepository.save(doctor));
    }

    public DoctorDTO updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setName(doctorDetails.getName());
            doctor.setSpecialty(doctorDetails.getSpecialty());
            doctor.setContact(doctorDetails.getContact());
            doctor.setEmail(doctorDetails.getEmail());
            return convertToDTO(doctorRepository.save(doctor));
        }).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    private DoctorDTO convertToDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getSpecialty(), doctor.getContact(), doctor.getEmail());
    }
}
