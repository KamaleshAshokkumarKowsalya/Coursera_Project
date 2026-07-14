package com.smartclinic.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartclinic.dto.AppointmentDto;
import com.smartclinic.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<AppointmentDto> listAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping("/patient/{patientId}")
    public List<AppointmentDto> appointmentsByPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }
}