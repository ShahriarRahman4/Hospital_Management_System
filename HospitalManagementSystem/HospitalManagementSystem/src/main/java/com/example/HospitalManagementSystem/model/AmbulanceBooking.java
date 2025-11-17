package com.example.HospitalManagementSystem.model;

import java.time.LocalDateTime;

public class AmbulanceBooking {
    private Long id;
    private Long patientId;
    private String phoneNumber;
    private String pickupAddress;
    private String pickupTime;
    private String emergencyType; // EMERGENCY, NON_EMERGENCY
    private String status; // PENDING, CONFIRMED, DISPATCHED, COMPLETED
    private String estimatedArrival;
    private LocalDateTime createdAt;

    // Constructors
    public AmbulanceBooking() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }
    public String getPickupTime() { return pickupTime; }
    public void setPickupTime(String pickupTime) { this.pickupTime = pickupTime; }
    public String getEmergencyType() { return emergencyType; }
    public void setEmergencyType(String emergencyType) { this.emergencyType = emergencyType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getEstimatedArrival() { return estimatedArrival; }
    public void setEstimatedArrival(String estimatedArrival) { this.estimatedArrival = estimatedArrival; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
