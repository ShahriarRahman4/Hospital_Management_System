package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.MedicalReport;
import com.example.HospitalManagementSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {
    
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalReport>> getPatientReports(@PathVariable Long patientId) {
        return ResponseEntity.ok(reportService.getPatientReports(patientId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MedicalReport> getReportById(@PathVariable Long id) {
        MedicalReport report = reportService.getReportById(id);
        if (report != null) {
            return ResponseEntity.ok(report);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<MedicalReport> uploadReport(@RequestBody MedicalReport report) {
        MedicalReport saved = reportService.uploadReport(report);
        return ResponseEntity.ok(saved);
    }
}
