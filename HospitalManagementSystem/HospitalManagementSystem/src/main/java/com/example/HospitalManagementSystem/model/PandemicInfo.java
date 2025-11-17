package com.example.HospitalManagementSystem.model;

import java.time.LocalDateTime;

public class PandemicInfo {
    private Long id;
    private String title;
    private String description;
    private Integer totalDoctors;
    private Integer availableRooms;
    private Integer medicineStock;
    private String equipmentAvailability;
    private LocalDateTime lastUpdated;

    // Constructors
    public PandemicInfo() {
        this.lastUpdated = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getTotalDoctors() { return totalDoctors; }
    public void setTotalDoctors(Integer totalDoctors) { this.totalDoctors = totalDoctors; }
    public Integer getAvailableRooms() { return availableRooms; }
    public void setAvailableRooms(Integer availableRooms) { this.availableRooms = availableRooms; }
    public Integer getMedicineStock() { return medicineStock; }
    public void setMedicineStock(Integer medicineStock) { this.medicineStock = medicineStock; }
    public String getEquipmentAvailability() { return equipmentAvailability; }
    public void setEquipmentAvailability(String equipmentAvailability) { this.equipmentAvailability = equipmentAvailability; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
