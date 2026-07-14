package com.smartclinic.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartclinic.entity.Prescription;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {

    List<Prescription> findByPatientId(Long patientId);
}