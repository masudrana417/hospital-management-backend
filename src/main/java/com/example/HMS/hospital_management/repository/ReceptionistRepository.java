package com.example.HMS.hospital_management.repository;

import com.example.HMS.hospital_management.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
}
