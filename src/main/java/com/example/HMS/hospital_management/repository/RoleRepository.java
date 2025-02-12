package com.example.HMS.hospital_management.repository;


import com.example.HMS.hospital_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, String> {

    boolean existsByRoleNameIgnoreCase(String roleName);

}
