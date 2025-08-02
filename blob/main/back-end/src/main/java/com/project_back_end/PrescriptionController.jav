package com.project_back_end.controllers;

import com.project_back_end.models.Prescription;
import com.project_back_end.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<?> savePrescription(@RequestHeader("Authorization") String token, @Valid @RequestBody Prescription prescription) {
        if (!prescriptionService.validateToken(token)) {
            return ResponseEntity.status(403).body("Unauthorized");
        }
        return ResponseEntity.ok(prescriptionService.save(prescription));
    }
}
