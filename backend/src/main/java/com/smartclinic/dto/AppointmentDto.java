package com.smartclinic.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentDto(Long id, Long doctorId, Long patientId, LocalDate appointmentDate, LocalDateTime appointmentTime, String status) {
}