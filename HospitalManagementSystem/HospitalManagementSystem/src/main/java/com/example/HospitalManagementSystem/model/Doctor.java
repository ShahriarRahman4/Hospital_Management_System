package com.example.HospitalManagementSystem.model;

import java.util.List;

public class Doctor {
    private Long id;
    private String name;
    private String department;
    private String qualification;
    private String specialization;
    private String experienceLevel; // JUNIOR, SPECIALIST, SENIOR
    private String email;
    private String phone;
    private String bio;
    private String photoUrl;
    private Boolean isAvailable = true;
    private List<String> availableSlots;

    // Constructors
    public Doctor() {}
    
    public Doctor(Long id, String name, String department, String qualification, 
                 String experienceLevel, String email, String phone) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.qualification = qualification;
        this.experienceLevel = experienceLevel;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getExperienceLevel() { return experienceLevel; }
    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
    public List<String> getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(List<String> availableSlots) { this.availableSlots = availableSlots; }
}