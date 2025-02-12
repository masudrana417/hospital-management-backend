package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.Appointment;
import com.example.HMS.hospital_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctor(User doctor);
    List<Appointment> findByPatient(User patient);
}