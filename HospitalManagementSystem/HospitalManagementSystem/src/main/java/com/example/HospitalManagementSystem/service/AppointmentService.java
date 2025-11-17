package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    
    private final Map<Long, Appointment> appointments = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private DoctorService doctorService;
    
    public Appointment bookAppointment(Appointment appointment) {
        Long id = idCounter.getAndIncrement();
        appointment.setId(id);
        appointment.setStatus("PENDING");
        appointments.put(id, appointment);
        return appointment;
    }
    
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments.values());
    }
    
    public List<Appointment> getPatientAppointments(Long patientId) {
        return appointments.values().stream()
            .filter(a -> a.getPatientId().equals(patientId))
            .collect(Collectors.toList());
    }
    
    public List<Appointment> getDoctorAppointments(Long doctorId) {
        return appointments.values().stream()
            .filter(a -> a.getDoctorId().equals(doctorId))
            .collect(Collectors.toList());
    }
    
    public Appointment updateAppointmentStatus(Long appointmentId, String status) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment != null) {
            appointment.setStatus(status);
        }
        return appointment;
    }
    
    public boolean cancelAppointment(Long appointmentId) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment != null && appointment.getStatus().equals("PENDING")) {
            appointment.setStatus("CANCELLED");
            return true;
        }
        return false;
    }
}
