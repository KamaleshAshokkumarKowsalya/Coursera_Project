package com.smartclinic.dto;

public record DoctorDto(Long id, String fullName, String email, String specialization, String phoneNumber) {
}