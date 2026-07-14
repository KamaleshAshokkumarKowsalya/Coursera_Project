package com.smartclinic.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartclinic.dto.DoctorDto;
import com.smartclinic.service.TokenService;
import com.smartclinic.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final TokenService tokenService;

    public DoctorController(DoctorService doctorService, TokenService tokenService) {
        this.doctorService = doctorService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public List<DoctorDto> listDoctors(@RequestParam(required = false) String name,
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) String time) {
        return doctorService.getDoctors(name, specialization, time);
    }

    @GetMapping("/availability")
    public ResponseEntity<Map<String, Object>> availability(@RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestParam Long doctorId,
            @RequestParam LocalDate date) {
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Missing token"));
        }
        String token = authorization.substring(7);
        String email = tokenService.extractUsername(token);
        if (!tokenService.isTokenValid(token, email)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid token"));
        }
        return ResponseEntity.ok(Map.of(
                "doctorId", doctorId,
                "date", date,
                "availableTimes", doctorService.getAvailableTimeSlots(doctorId, date)));
    }
}