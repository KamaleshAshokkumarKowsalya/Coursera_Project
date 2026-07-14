package com.smartclinic.dto;

import java.time.LocalDate;

public record PatientDto(Long id, String fullName, String email, String gender, LocalDate dateOfBirth) {
}