package com.example.HMS.hospital_management.dto;

public class DoctorDTO {
    private Long id;
    private String name;
    private String specialty;
    private String contact;
    private String email;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String specialty, String contact, String email) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.contact = contact;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
