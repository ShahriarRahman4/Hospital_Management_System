package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.FundingRequest;
import com.example.HospitalManagementSystem.service.FundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/funding")
@CrossOrigin("*")
public class FundingController {
    
    @Autowired
    private FundingService fundingService;
    
    @PostMapping("/request")
    public ResponseEntity<FundingRequest> createFundingRequest(@RequestBody FundingRequest request) {
        FundingRequest created = fundingService.createFundingRequest(request);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<FundingRequest>> getPatientFundingRequests(@PathVariable Long patientId) {
        return ResponseEntity.ok(fundingService.getPatientFundingRequests(patientId));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<FundingRequest>> getAllFundingRequests() {
        return ResponseEntity.ok(fundingService.getAllFundingRequests());
    }
    
    @PutMapping("/{id}/approve")
    public ResponseEntity<FundingRequest> approveFundingRequest(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String adminNotes = request.get("adminNotes");
        FundingRequest approved = fundingService.approveFundingRequest(id, adminNotes);
        return ResponseEntity.ok(approved);
    }
    
    @PutMapping("/{id}/reject")
    public ResponseEntity<FundingRequest> rejectFundingRequest(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String adminNotes = request.get("adminNotes");
        FundingRequest rejected = fundingService.rejectFundingRequest(id, adminNotes);
        return ResponseEntity.ok(rejected);
    }
    
    @PutMapping("/{id}/transfer-funds")
    public ResponseEntity<Map<String, String>> transferFunds(@PathVariable Long id) {
        boolean transferred = fundingService.transferFundsToBank(id);
        if (transferred) {
            return ResponseEntity.ok(Map.of("message", "Funds transferred successfully"));
        }
        return ResponseEntity.badRequest().body(Map.of("message", "Failed to transfer funds"));
    }
    
    @GetMapping("/ngos")
    public ResponseEntity<List<Map<String, String>>> getNGOs() {
        return ResponseEntity.ok(fundingService.getNGOs());
    }
}
