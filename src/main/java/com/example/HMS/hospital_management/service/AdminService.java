package com.example.HMS.hospital_management.service;


import com.example.HMS.hospital_management.dto.AdminDTO;
import com.example.HMS.hospital_management.entity.Admin;
import com.example.HMS.hospital_management.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AdminDTO getAdminById(Long id) {
        return adminRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public AdminDTO createAdmin(Admin admin) {
        return convertToDTO(adminRepository.save(admin));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    private AdminDTO convertToDTO(Admin admin) {
        return new AdminDTO(admin.getId(), admin.getName(), admin.getEmail(), admin.getContact());
    }
}