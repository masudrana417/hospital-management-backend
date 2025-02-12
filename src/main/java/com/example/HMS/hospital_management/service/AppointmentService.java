package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.dto.AppointmentDTO;
import com.example.HMS.hospital_management.entity.Appointment;
import com.example.HMS.hospital_management.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        return appointmentRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public AppointmentDTO createAppointment(Appointment appointment) {
        return convertToDTO(appointmentRepository.save(appointment));
    }

    public AppointmentDTO updateAppointment(Long id, Appointment appointmentDetails) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            appointment.setStatus(appointmentDetails.getStatus());
            return convertToDTO(appointmentRepository.save(appointment));
        }).orElse(null);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return new AppointmentDTO(appointment.getId(), appointment.getPatient().getId(), appointment.getDoctor().getId(), appointment.getAppointmentDate(), appointment.getStatus());
    }
}