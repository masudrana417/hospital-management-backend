package com.example.HMS.hospital_management.repository;


import com.example.HMS.hospital_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUserNameIgnoreCase(String userName);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);
}
