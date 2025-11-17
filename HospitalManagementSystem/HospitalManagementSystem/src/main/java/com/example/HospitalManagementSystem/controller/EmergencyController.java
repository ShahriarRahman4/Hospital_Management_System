package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.AmbulanceBooking;
import com.example.HospitalManagementSystem.model.BloodBank;
import com.example.HospitalManagementSystem.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emergency")
@CrossOrigin("*")
public class EmergencyController {
    
    @Autowired
    private EmergencyService emergencyService;
    
    // Ambulance Booking
    @PostMapping("/ambulance")
    public ResponseEntity<AmbulanceBooking> bookAmbulance(@RequestBody AmbulanceBooking booking) {
        AmbulanceBooking booked = emergencyService.bookAmbulance(booking);
        return ResponseEntity.ok(booked);
    }
    
    @GetMapping("/ambulance/patient/{patientId}")
    public ResponseEntity<List<AmbulanceBooking>> getAmbulanceBookings(@PathVariable Long patientId) {
        return ResponseEntity.ok(emergencyService.getAmbulanceBookings(patientId));
    }
    
    @PostMapping("/ambulance/call-me")
    public ResponseEntity<Map<String, String>> requestCallBack(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("phoneNumber");
        emergencyService.requestCallBack(phoneNumber);
        return ResponseEntity.ok(Map.of("message", "We will call you back shortly"));
    }
    
    // Blood Bank
    @GetMapping("/blood-bank")
    public ResponseEntity<List<BloodBank>> getBloodBankInventory() {
        return ResponseEntity.ok(emergencyService.getBloodBankInventory());
    }
    
    @PostMapping("/blood-bank/request")
    public ResponseEntity<Map<String, String>> requestBlood(@RequestBody Map<String, Object> request) {
        String bloodGroup = (String) request.get("bloodGroup");
        Integer units = (Integer) request.get("units");
        String patientName = (String) request.get("patientName");
        String contactNumber = (String) request.get("contactNumber");
        
        boolean available = emergencyService.requestBlood(bloodGroup, units, patientName, contactNumber);
        if (available) {
            return ResponseEntity.ok(Map.of("message", "Blood request submitted successfully"));
        }
        return ResponseEntity.badRequest().body(Map.of("message", "Blood not available"));
    }
}
