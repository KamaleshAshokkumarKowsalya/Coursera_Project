package com.smartclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartclinic.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByFullNameContainingIgnoreCase(String fullName);

    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);
}