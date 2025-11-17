package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.MedicalReport;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ReportService {
    
    private final Map<Long, MedicalReport> medicalReports = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    
    public List<MedicalReport> getPatientReports(Long patientId) {
        return medicalReports.values().stream()
            .filter(r -> r.getPatientId().equals(patientId))
            .collect(Collectors.toList());
    }
    
    public MedicalReport getReportById(Long id) {
        return medicalReports.get(id);
    }
    
    public MedicalReport uploadReport(MedicalReport report) {
        Long id = idCounter.getAndIncrement();
        report.setId(id);
        if (report.getReportDate() == null) {
            report.setReportDate(LocalDate.now());
        }
        medicalReports.put(id, report);
        return report;
    }
}
