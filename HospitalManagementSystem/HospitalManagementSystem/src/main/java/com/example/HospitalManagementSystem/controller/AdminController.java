package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.*;
import com.example.HospitalManagementSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {
    
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private FundingService fundingService;
    
    @Autowired
    private EmergencyService emergencyService;
    
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        return ResponseEntity.ok(Map.of(
            "totalAppointments", appointmentService.getAllAppointments().size(),
            "pendingAppointments", appointmentService.getAllAppointments().stream()
                .filter(a -> "PENDING".equals(a.getStatus())).count(),
            "totalPatients", 0, // Add patient service count
            "totalDoctors", 0 // Add doctor service count
        ));
    }
    
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
    
    @PutMapping("/appointments/{id}/approve")
    public ResponseEntity<Appointment> approveAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.updateAppointmentStatus(id, "CONFIRMED");
        return ResponseEntity.ok(appointment);
    }
    
    @GetMapping("/funding-requests")
    public ResponseEntity<List<FundingRequest>> getAllFundingRequests() {
        return ResponseEntity.ok(fundingService.getAllFundingRequests());
    }
    
    @GetMapping("/hospital-transfers")
    public ResponseEntity<List<HospitalTransfer>> getAllHospitalTransfers() {
        return ResponseEntity.ok(emergencyService.getAllHospitalTransfers());
    }
    
    @PutMapping("/hospital-transfers/{id}/approve")
    public ResponseEntity<HospitalTransfer> approveTransfer(@PathVariable Long id) {
        HospitalTransfer transfer = emergencyService.approveHospitalTransfer(id);
        return ResponseEntity.ok(transfer);
    }
    
    @PutMapping("/hospital-transfers/{id}/reject")
    public ResponseEntity<HospitalTransfer> rejectTransfer(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String reason = request.get("reason");
        HospitalTransfer transfer = emergencyService.rejectHospitalTransfer(id, reason);
        return ResponseEntity.ok(transfer);
    }
}
