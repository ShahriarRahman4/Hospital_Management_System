package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.HospitalTransfer;
import com.example.HospitalManagementSystem.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-transfers")
@CrossOrigin("*")
public class HospitalTransferController {
    
    @Autowired
    private EmergencyService emergencyService;
    
    @PostMapping
    public ResponseEntity<HospitalTransfer> createTransfer(@RequestBody HospitalTransfer transfer) {
        HospitalTransfer created = emergencyService.createHospitalTransfer(transfer);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HospitalTransfer>> getPatientTransfers(@PathVariable Long patientId) {
        return ResponseEntity.ok(emergencyService.getPatientHospitalTransfers(patientId));
    }
    
    @GetMapping("/hospitals")
    public ResponseEntity<List<String>> getHospitalList() {
        return ResponseEntity.ok(emergencyService.getHospitalList());
    }
}

