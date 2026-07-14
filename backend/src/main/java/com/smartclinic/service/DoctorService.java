package com.smartclinic.service;

import java.time.LocalDate;
import java.util.List;

import com.smartclinic.dto.DoctorDto;

import org.springframework.http.ResponseEntity;

public interface DoctorService {

    List<DoctorDto> getDoctors(String name, String specialization, String time);

    List<String> getAvailableTimeSlots(Long doctorId, LocalDate date);

    ResponseEntity<?> validateDoctorLogin(String email, String password);
}