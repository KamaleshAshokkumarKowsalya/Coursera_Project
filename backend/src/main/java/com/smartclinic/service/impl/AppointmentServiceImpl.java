package com.smartclinic.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smartclinic.dto.AppointmentDto;
import com.smartclinic.entity.Appointment;
import com.smartclinic.repository.AppointmentRepository;
import com.smartclinic.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentDto> getAppointments() {
        return appointmentRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public List<AppointmentDto> getAppointmentsForDoctorOnDate(Long doctorId, LocalDate date) {
        return appointmentRepository.findByDoctor_IdAndAppointmentDate(doctorId, date).stream().map(this::toDto).toList();
    }

    @Override
    public List<AppointmentDto> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatient_Id(patientId).stream().map(this::toDto).toList();
    }

    private AppointmentDto toDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getDoctor() != null ? appointment.getDoctor().getId() : null,
                appointment.getPatient() != null ? appointment.getPatient().getId() : null,
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getStatus());
    }
}