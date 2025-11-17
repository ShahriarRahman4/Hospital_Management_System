package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    
    private final Map<Long, Doctor> doctors = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(100);
    
    public Doctor addDoctor(Doctor doctor) {
        Long id = idCounter.getAndIncrement();
        doctor.setId(id);
        doctors.put(id, doctor);
        return doctor;
    }
    
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }
    
    public Doctor getDoctorById(Long id) {
        return doctors.get(id);
    }
    
    public List<Doctor> findDoctorsByDepartment(String department) {
        return doctors.values().stream()
            .filter(d -> d.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }
    
    public List<Doctor> searchDoctorsByName(String name) {
        return doctors.values().stream()
            .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }
    
    public List<String> getAllDepartments() {
        return doctors.values().stream()
            .map(Doctor::getDepartment)
            .distinct()
            .collect(Collectors.toList());
    }
}
