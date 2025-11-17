package com.example.HospitalManagementSystem.model;

import java.time.LocalDateTime;

public class HospitalTransfer {
    private Long id;
    private Long patientId;
    private String fromHospital;
    private String toHospital;
    private String transferReason;
    private Boolean ambulanceRequired;
    private String preferredTime;
    private String status; // PENDING, APPROVED, REJECTED, COMPLETED
    private String rejectionReason;
    private LocalDateTime createdAt;

    // Constructors
    public HospitalTransfer() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public String getFromHospital() { return fromHospital; }
    public void setFromHospital(String fromHospital) { this.fromHospital = fromHospital; }
    public String getToHospital() { return toHospital; }
    public void setToHospital(String toHospital) { this.toHospital = toHospital; }
    public String getTransferReason() { return transferReason; }
    public void setTransferReason(String transferReason) { this.transferReason = transferReason; }
    public Boolean getAmbulanceRequired() { return ambulanceRequired; }
    public void setAmbulanceRequired(Boolean ambulanceRequired) { this.ambulanceRequired = ambulanceRequired; }
    public String getPreferredTime() { return preferredTime; }
    public void setPreferredTime(String preferredTime) { this.preferredTime = preferredTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
