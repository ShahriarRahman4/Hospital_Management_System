package com.example.HospitalManagementSystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BloodBank {
    private Long id;
    private String bloodGroup;
    private Integer unitsAvailable;
    private LocalDate expiryDate;
    private String status; // AVAILABLE, LOW, EXPIRED
    private LocalDateTime lastUpdated;

    // Constructors
    public BloodBank() {
        this.lastUpdated = LocalDateTime.now();
        this.status = "AVAILABLE";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public Integer getUnitsAvailable() { return unitsAvailable; }
    public void setUnitsAvailable(Integer unitsAvailable) { 
        this.unitsAvailable = unitsAvailable;
        if (unitsAvailable != null) {
            if (unitsAvailable == 0) {
                this.status = "EXPIRED";
            } else if (unitsAvailable < 5) {
                this.status = "LOW";
            } else {
                this.status = "AVAILABLE";
            }
        }
    }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { 
        this.expiryDate = expiryDate;
        if (expiryDate != null && expiryDate.isBefore(LocalDate.now())) {
            this.status = "EXPIRED";
        }
    }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
