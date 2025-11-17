package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.AmbulanceBooking;
import com.example.HospitalManagementSystem.model.BloodBank;
import com.example.HospitalManagementSystem.model.HospitalTransfer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class EmergencyService {
    
    private final Map<Long, AmbulanceBooking> ambulanceBookings = new ConcurrentHashMap<>();
    private final Map<Long, BloodBank> bloodBankInventory = new ConcurrentHashMap<>();
    private final Map<Long, HospitalTransfer> hospitalTransfers = new ConcurrentHashMap<>();
    private final AtomicLong ambulanceIdCounter = new AtomicLong(1);
    private final AtomicLong bloodBankIdCounter = new AtomicLong(1);
    private final AtomicLong transferIdCounter = new AtomicLong(1);
    
    public EmergencyService() {
        initializeBloodBank();
    }
    
    private void initializeBloodBank() {
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        for (String group : bloodGroups) {
            BloodBank blood = new BloodBank();
            blood.setId(bloodBankIdCounter.getAndIncrement());
            blood.setBloodGroup(group);
            blood.setUnitsAvailable(20);
            blood.setStatus("AVAILABLE");
            bloodBankInventory.put(blood.getId(), blood);
        }
    }
    
    // Ambulance Booking
    public AmbulanceBooking bookAmbulance(AmbulanceBooking booking) {
        Long id = ambulanceIdCounter.getAndIncrement();
        booking.setId(id);
        booking.setStatus("PENDING");
        booking.setEstimatedArrival("~20 minutes");
        booking.setCreatedAt(LocalDateTime.now());
        ambulanceBookings.put(id, booking);
        return booking;
    }
    
    public List<AmbulanceBooking> getAmbulanceBookings(Long patientId) {
        return ambulanceBookings.values().stream()
            .filter(b -> b.getPatientId().equals(patientId))
            .collect(Collectors.toList());
    }
    
    public void requestCallBack(String phoneNumber) {
        // In a real system, this would trigger a callback service
        System.out.println("Callback requested for: " + phoneNumber);
    }
    
    // Blood Bank
    public List<BloodBank> getBloodBankInventory() {
        return new ArrayList<>(bloodBankInventory.values());
    }
    
    public boolean requestBlood(String bloodGroup, Integer units, String patientName, String contactNumber) {
        BloodBank blood = bloodBankInventory.values().stream()
            .filter(b -> b.getBloodGroup().equals(bloodGroup))
            .findFirst()
            .orElse(null);
        
        if (blood != null && blood.getUnitsAvailable() >= units) {
            blood.setUnitsAvailable(blood.getUnitsAvailable() - units);
            blood.setLastUpdated(LocalDateTime.now());
            return true;
        }
        return false;
    }
    
    // Hospital Transfer
    public HospitalTransfer createHospitalTransfer(HospitalTransfer transfer) {
        Long id = transferIdCounter.getAndIncrement();
        transfer.setId(id);
        transfer.setStatus("PENDING");
        transfer.setCreatedAt(LocalDateTime.now());
        hospitalTransfers.put(id, transfer);
        return transfer;
    }
    
    public List<HospitalTransfer> getAllHospitalTransfers() {
        return new ArrayList<>(hospitalTransfers.values());
    }
    
    public List<HospitalTransfer> getPatientHospitalTransfers(Long patientId) {
        return hospitalTransfers.values().stream()
            .filter(t -> t.getPatientId().equals(patientId))
            .collect(Collectors.toList());
    }
    
    public HospitalTransfer approveHospitalTransfer(Long id) {
        HospitalTransfer transfer = hospitalTransfers.get(id);
        if (transfer != null) {
            transfer.setStatus("APPROVED");
        }
        return transfer;
    }
    
    public HospitalTransfer rejectHospitalTransfer(Long id, String reason) {
        HospitalTransfer transfer = hospitalTransfers.get(id);
        if (transfer != null) {
            transfer.setStatus("REJECTED");
            transfer.setRejectionReason(reason);
        }
        return transfer;
    }
    
    public List<String> getHospitalList() {
        return Arrays.asList(
            "Square Hospital",
            "Dhaka Medical College",
            "LabAID",
            "Green Life Hospital",
            "Ibn Sina Hospital"
        );
    }
}
