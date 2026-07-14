package com.smartclinic.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smartclinic.dto.DoctorDto;
import com.smartclinic.domain.Role;
import com.smartclinic.entity.Appointment;
import com.smartclinic.entity.Doctor;
import com.smartclinic.repository.AppointmentRepository;
import com.smartclinic.repository.DoctorRepository;
import com.smartclinic.repository.UserAccountRepository;
import com.smartclinic.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final UserAccountRepository userAccountRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository,
            AppointmentRepository appointmentRepository,
            UserAccountRepository userAccountRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public List<DoctorDto> getDoctors(String name, String specialization, String time) {
        List<Doctor> doctors;
        if ((name == null || name.isBlank()) && (specialization == null || specialization.isBlank())) {
            doctors = doctorRepository.findAll();
        } else if (name != null && !name.isBlank() && (specialization == null || specialization.isBlank())) {
            doctors = doctorRepository.findByFullNameContainingIgnoreCase(name);
        } else if ((name == null || name.isBlank())) {
            doctors = doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
        } else {
            doctors = doctorRepository.findAll().stream()
                    .filter(doctor -> doctor.getFullName().toLowerCase().contains(name.toLowerCase())
                            || (doctor.getSpecialization() != null
                            && doctor.getSpecialization().toLowerCase().contains(specialization.toLowerCase())))
                    .toList();
        }
        return doctors.stream()
                .map(doctor -> new DoctorDto(doctor.getId(), doctor.getFullName(), doctor.getEmail(), doctor.getSpecialization(), doctor.getPhoneNumber()))
                .toList();
    }

            @Override
            public List<String> getAvailableTimeSlots(Long doctorId, LocalDate date) {
            Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
            if (doctor == null || doctor.getAvailableTimes() == null) {
                return List.of();
            }

            List<String> bookedSlots = appointmentRepository.findByDoctor_IdAndAppointmentDate(doctorId, date).stream()
                .map(Appointment::getAppointmentTime)
                .map(time -> time.toLocalTime().toString())
                .toList();

            return doctor.getAvailableTimes().stream()
                .filter(slot -> !bookedSlots.contains(slot))
                .toList();
            }

            @Override
            public ResponseEntity<?> validateDoctorLogin(String email, String password) {
            return userAccountRepository.findByEmailAndPasswordAndRole(email, password, Role.DOCTOR)
                .map(user -> ResponseEntity.ok(Map.of(
                    "message", "Doctor login successful",
                    "email", user.getEmail(),
                    "role", user.getRole().name())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid doctor credentials")));
            }
}