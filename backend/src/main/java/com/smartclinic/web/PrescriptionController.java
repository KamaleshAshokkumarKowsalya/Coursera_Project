package com.smartclinic.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.smartclinic.entity.Prescription;
import com.smartclinic.repository.PrescriptionRepository;
import com.smartclinic.service.TokenService;
import com.smartclinic.web.request.PrescriptionRequest;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;
    private final TokenService tokenService;

    public PrescriptionController(PrescriptionRepository prescriptionRepository, TokenService tokenService) {
        this.prescriptionRepository = prescriptionRepository;
        this.tokenService = tokenService;
    }

    @GetMapping
    public List<Prescription> listPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public List<Prescription> prescriptionsByPatient(@PathVariable Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> savePrescription(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @Valid @RequestBody PrescriptionRequest request) {
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Missing token"));
        }
        String token = authorization.substring(7);
        String email = tokenService.extractUsername(token);
        if (!tokenService.isTokenValid(token, email)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid token"));
        }

        Prescription prescription = new Prescription();
        prescription.setPatientId(request.patientId());
        prescription.setDoctorId(request.doctorId());
        prescription.setMedicineNames(request.medicineNames());
        prescription.setDosageInstructions(request.dosageInstructions());
        prescription.setAdditionalNotes(request.additionalNotes());
        prescriptionRepository.save(prescription);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "Prescription saved successfully",
                "prescriptionId", prescription.getId()));
    }
}