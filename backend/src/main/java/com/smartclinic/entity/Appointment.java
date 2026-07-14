package com.smartclinic.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotNull
    private LocalDate appointmentDate;

    @NotNull
    private LocalDateTime appointmentTime;

    private String status = "SCHEDULED";
}