package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.Patient;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PatientService {
    
    private final Map<Long, Patient> patients = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1000);
    
    public Patient registerPatient(Patient patient) {
        Long id = idCounter.getAndIncrement();
        patient.setId(id);
        if (patient.getPatientId() == null || patient.getPatientId().isEmpty()) {
            patient.setPatientId("PID" + id);
        }
        patients.put(id, patient);
        return patient;
    }
    
    public Patient loginPatient(String patientId, String password) {
        return patients.values().stream()
            .filter(p -> p.getPatientId().equals(patientId) && p.getPassword().equals(password))
            .findFirst()
            .orElse(null);
    }
    
    public Patient getPatientById(Long id) {
        return patients.get(id);
    }
    
    public Patient getPatientByPatientId(String patientId) {
        return patients.values().stream()
            .filter(p -> p.getPatientId().equals(patientId))
            .findFirst()
            .orElse(null);
    }
    
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }
    
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient patient = patients.get(id);
        if (patient != null) {
            patient.setFullName(patientDetails.getFullName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setAddress(patientDetails.getAddress());
            patient.setPhone(patientDetails.getPhone());
            patient.setEmail(patientDetails.getEmail());
            patient.setEmergencyContact(patientDetails.getEmergencyContact());
            patient.setBloodGroup(patientDetails.getBloodGroup());
        }
        return patient;
    }
}
