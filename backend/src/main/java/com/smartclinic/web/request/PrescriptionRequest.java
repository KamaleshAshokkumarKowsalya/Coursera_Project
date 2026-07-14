package com.smartclinic.web.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PrescriptionRequest(
        @NotNull Long patientId,
        @NotNull Long doctorId,
        @NotNull @Size(min = 1) List<@NotBlank String> medicineNames,
        @NotBlank String dosageInstructions,
        String additionalNotes) {
}