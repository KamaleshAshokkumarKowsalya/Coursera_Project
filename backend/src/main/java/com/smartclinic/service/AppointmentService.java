package com.smartclinic.service;

import java.time.LocalDate;
import java.util.List;

import com.smartclinic.dto.AppointmentDto;
import com.smartclinic.entity.Appointment;

public interface AppointmentService {

    Appointment bookAppointment(Appointment appointment);

    List<AppointmentDto> getAppointments();

    List<AppointmentDto> getAppointmentsForDoctorOnDate(Long doctorId, LocalDate date);

    List<AppointmentDto> getAppointmentsByPatientId(Long patientId);
}