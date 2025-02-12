package com.example.HMS.hospital_management.service;



import com.example.HMS.hospital_management.dto.ReceptionistDTO;
import com.example.HMS.hospital_management.entity.Receptionist;
import com.example.HMS.hospital_management.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptionistService {
    @Autowired
    private ReceptionistRepository receptionistRepository;

    public List<ReceptionistDTO> getAllReceptionists() {
        return receptionistRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReceptionistDTO getReceptionistById(Long id) {
        return receptionistRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public ReceptionistDTO createReceptionist(Receptionist receptionist) {
        return convertToDTO(receptionistRepository.save(receptionist));
    }

    public void deleteReceptionist(Long id) {
        receptionistRepository.deleteById(id);
    }

    private ReceptionistDTO convertToDTO(Receptionist receptionist) {
        return new ReceptionistDTO(receptionist.getId(), receptionist.getName(), receptionist.getEmail(), receptionist.getContact());
    }
}