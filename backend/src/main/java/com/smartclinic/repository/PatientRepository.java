package com.smartclinic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartclinic.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Optional<Patient> findByEmail(String email);

	Optional<Patient> findByEmailOrPhoneNumber(String email, String phoneNumber);
}