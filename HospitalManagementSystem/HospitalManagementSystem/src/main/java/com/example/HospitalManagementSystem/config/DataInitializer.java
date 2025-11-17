package com.example.HospitalManagementSystem.config;

import com.example.HospitalManagementSystem.model.*;
import com.example.HospitalManagementSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataInitializer {
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private FundingService fundingService;
    
    @PostConstruct
    public void init() {
        initializeDoctors();
        initializePatients();
        initializeAppointments();
        initializeReports();
        initializeFundingRequests();
    }
    
    private void initializeDoctors() {
        // Cardiology
        Doctor d1 = new Doctor();
        d1.setName("Dr. James Carter");
        d1.setDepartment("Cardiology");
        d1.setQualification("MD, Heart Specialist");
        d1.setExperienceLevel("SENIOR");
        d1.setEmail("james.carter@hospital.com");
        d1.setPhone("+1-202-555-0101");
        d1.setBio("Over 20 years of experience in cardiology with expertise in interventional procedures.");
        d1.setAvailableSlots(Arrays.asList("09:00 AM - 11:00 AM", "02:00 PM - 04:00 PM"));
        doctorService.addDoctor(d1);
        
        Doctor d2 = new Doctor();
        d2.setName("Dr. Emily Stone");
        d2.setDepartment("Cardiology");
        d2.setQualification("MBBS, MD, Cardiac Surgeon");
        d2.setExperienceLevel("SENIOR");
        d2.setEmail("emily.stone@hospital.com");
        d2.setPhone("+1-202-555-0102");
        d2.setBio("Renowned cardiac surgeon with expertise in complex heart surgeries.");
        d2.setAvailableSlots(Arrays.asList("10:00 AM - 12:00 PM", "03:00 PM - 05:00 PM"));
        doctorService.addDoctor(d2);
        
        // Neurology
        Doctor d3 = new Doctor();
        d3.setName("Dr. William Smith");
        d3.setDepartment("Neurology");
        d3.setQualification("MBBS, MD, Neurosurgeon");
        d3.setExperienceLevel("SENIOR");
        d3.setEmail("william.smith@hospital.com");
        d3.setPhone("+1-202-555-0103");
        d3.setBio("Expert neurosurgeon specializing in brain and spinal surgeries.");
        d3.setAvailableSlots(Arrays.asList("09:00 AM - 11:00 AM", "02:00 PM - 04:00 PM"));
        doctorService.addDoctor(d3);
        
        Doctor d4 = new Doctor();
        d4.setName("Dr. Ava Johnson");
        d4.setDepartment("Neurology");
        d4.setQualification("DM Neurology, Neurophysiologist");
        d4.setExperienceLevel("SPECIALIST");
        d4.setEmail("ava.johnson@hospital.com");
        d4.setPhone("+1-202-555-0104");
        d4.setBio("Specialized in neurological disorders and neurophysiology.");
        d4.setAvailableSlots(Arrays.asList("11:00 AM - 01:00 PM", "04:00 PM - 06:00 PM"));
        doctorService.addDoctor(d4);
        
        // Orthopedics
        Doctor d5 = new Doctor();
        d5.setName("Dr. Henry Davis");
        d5.setDepartment("Orthopedics");
        d5.setQualification("MS Orthopedics, Bone & Joint Specialist");
        d5.setExperienceLevel("SENIOR");
        d5.setEmail("henry.davis@hospital.com");
        d5.setPhone("+1-202-555-0105");
        d5.setBio("Expert in bone and joint surgeries with 15+ years of experience.");
        d5.setAvailableSlots(Arrays.asList("09:00 AM - 11:00 AM", "02:00 PM - 04:00 PM"));
        doctorService.addDoctor(d5);
        
        Doctor d6 = new Doctor();
        d6.setName("Dr. Charlotte Lewis");
        d6.setDepartment("Orthopedics");
        d6.setQualification("MS Sports Medicine, Sports Injury Specialist");
        d6.setExperienceLevel("SPECIALIST");
        d6.setEmail("charlotte.lewis@hospital.com");
        d6.setPhone("+1-202-555-0106");
        d6.setBio("Specialized in sports medicine and athletic injuries.");
        d6.setAvailableSlots(Arrays.asList("10:00 AM - 12:00 PM", "03:00 PM - 05:00 PM"));
        doctorService.addDoctor(d6);
        
        // Dermatology
        Doctor d7 = new Doctor();
        d7.setName("Dr. Amelia Scott");
        d7.setDepartment("Dermatology");
        d7.setQualification("MD Dermatology, Skin Specialist");
        d7.setExperienceLevel("SENIOR");
        d7.setEmail("amelia.scott@hospital.com");
        d7.setPhone("+1-202-555-0107");
        d7.setBio("Expert dermatologist with expertise in skin conditions and cosmetic procedures.");
        d7.setAvailableSlots(Arrays.asList("09:00 AM - 11:00 AM", "02:00 PM - 04:00 PM"));
        doctorService.addDoctor(d7);
        
        // Medicine
        Doctor d8 = new Doctor();
        d8.setName("Dr. William Carter");
        d8.setDepartment("Medicine");
        d8.setQualification("MBBS, MD");
        d8.setExperienceLevel("SENIOR");
        d8.setEmail("william.carter@hospital.com");
        d8.setPhone("+1-202-555-0108");
        d8.setBio("Senior Consultant in Internal Medicine with comprehensive medical expertise.");
        d8.setAvailableSlots(Arrays.asList("09:00 AM - 11:00 AM", "11:00 AM - 01:00 PM", "02:00 PM - 04:00 PM"));
        doctorService.addDoctor(d8);
        
        Doctor d9 = new Doctor();
        d9.setName("Dr. Olivia Green");
        d9.setDepartment("Medicine");
        d9.setQualification("MBBS, MD");
        d9.setExperienceLevel("SPECIALIST");
        d9.setEmail("olivia.green@hospital.com");
        d9.setPhone("+1-202-555-0109");
        d9.setBio("Consultant specializing in Cardio-Medicine.");
        d9.setAvailableSlots(Arrays.asList("10:00 AM - 12:00 PM", "04:00 PM - 06:00 PM"));
        doctorService.addDoctor(d9);
        
        // Counselling Center
        Doctor d10 = new Doctor();
        d10.setName("Dr. Sarah Mitchell");
        d10.setDepartment("Counselling Center");
        d10.setQualification("PhD, Clinical Psychologist");
        d10.setExperienceLevel("SENIOR");
        d10.setEmail("sarah.mitchell@hospital.com");
        d10.setPhone("+1-202-555-0110");
        d10.setBio("Licensed clinical psychologist with expertise in mental health counseling.");
        d10.setAvailableSlots(Arrays.asList("09:00 AM - 11:00 AM", "02:00 PM - 04:00 PM", "04:00 PM - 06:00 PM"));
        doctorService.addDoctor(d10);
        
        Doctor d11 = new Doctor();
        d11.setName("Dr. Daniel Perez");
        d11.setDepartment("Counselling Center");
        d11.setQualification("MA, Licensed Counsellor");
        d11.setExperienceLevel("SPECIALIST");
        d11.setEmail("daniel.perez@hospital.com");
        d11.setPhone("+1-202-555-0111");
        d11.setBio("Licensed counselor specializing in family and individual therapy.");
        d11.setAvailableSlots(Arrays.asList("11:00 AM - 01:00 PM", "03:00 PM - 05:00 PM"));
        doctorService.addDoctor(d11);
    }
    
    private void initializePatients() {
        Patient p1 = new Patient();
        p1.setPatientId("242241");
        p1.setFullName("Alice Johnson");
        p1.setAge(28);
        p1.setGender("Female");
        p1.setPhone("1234567890");
        p1.setEmail("alice.johnson@email.com");
        p1.setAddress("123 Main Street, City");
        p1.setBloodGroup("O+");
        p1.setPassword("password123");
        patientService.registerPatient(p1);
        
        Patient p2 = new Patient();
        p2.setPatientId("242242");
        p2.setFullName("Bob Smith");
        p2.setAge(45);
        p2.setGender("Male");
        p2.setPhone("1234567891");
        p2.setEmail("bob.smith@email.com");
        p2.setAddress("456 Oak Avenue, City");
        p2.setBloodGroup("A+");
        p2.setPassword("password123");
        patientService.registerPatient(p2);
        
        Patient p3 = new Patient();
        p3.setPatientId("242243");
        p3.setFullName("Emma Wilson");
        p3.setAge(35);
        p3.setGender("Female");
        p3.setPhone("1234567892");
        p3.setEmail("emma.wilson@email.com");
        p3.setAddress("789 Pine Road, City");
        p3.setBloodGroup("B+");
        p3.setPassword("password123");
        patientService.registerPatient(p3);
    }
    
    private void initializeAppointments() {
        // Get patient and doctor IDs (assuming they exist)
        Long patientId1 = 1000L; // Alice Johnson
        Long patientId2 = 1001L; // Bob Smith
        Long doctorId1 = 100L; // Dr. James Carter
        
        Appointment a1 = new Appointment();
        a1.setPatientId(patientId1);
        a1.setDoctorId(doctorId1);
        a1.setAppointmentDate(LocalDate.now().plusDays(5));
        a1.setAppointmentTime(LocalTime.of(10, 0));
        a1.setType("IN_PERSON");
        a1.setDepartment("Cardiology");
        a1.setSymptoms("Chest pain and shortness of breath");
        a1.setStatus("CONFIRMED");
        appointmentService.bookAppointment(a1);
        
        Appointment a2 = new Appointment();
        a2.setPatientId(patientId2);
        a2.setDoctorId(doctorId1);
        a2.setAppointmentDate(LocalDate.now().plusDays(7));
        a2.setAppointmentTime(LocalTime.of(14, 30));
        a2.setType("ONLINE");
        a2.setDepartment("Cardiology");
        a2.setSymptoms("Regular checkup");
        a2.setStatus("PENDING");
        appointmentService.bookAppointment(a2);
    }
    
    private void initializeReports() {
        Long patientId1 = 1000L;
        Long patientId2 = 1001L;
        
        MedicalReport r1 = new MedicalReport();
        r1.setPatientId(patientId1);
        r1.setReportType("Blood Test");
        r1.setReportDate(LocalDate.now().minusDays(30));
        r1.setDoctorNotes("Complete Blood Count - All parameters within normal range.");
        r1.setTestResults("RBC: 4.5, WBC: 7000, Hemoglobin: 14.2, Platelets: 250000");
        r1.setFileUrl("/reports/blood-test-242241-2024.pdf");
        reportService.uploadReport(r1);
        
        MedicalReport r2 = new MedicalReport();
        r2.setPatientId(patientId1);
        r2.setReportType("X-Ray");
        r2.setReportDate(LocalDate.now().minusDays(15));
        r2.setDoctorNotes("Chest X-Ray - Normal findings, no abnormalities detected.");
        r2.setTestResults("Chest X-Ray shows clear lung fields, normal heart size.");
        r2.setFileUrl("/reports/xray-242241-2024.jpg");
        reportService.uploadReport(r2);
        
        MedicalReport r3 = new MedicalReport();
        r3.setPatientId(patientId2);
        r3.setReportType("ECG");
        r3.setReportDate(LocalDate.now().minusDays(10));
        r3.setDoctorNotes("ECG - Normal sinus rhythm, no abnormalities.");
        r3.setTestResults("Heart rate: 72 bpm, Regular rhythm, Normal ECG pattern.");
        r3.setFileUrl("/reports/ecg-242242-2024.pdf");
        reportService.uploadReport(r3);
    }
    
    private void initializeFundingRequests() {
        FundingRequest f1 = new FundingRequest();
        f1.setPatientId(1000L);
        f1.setPatientName("Alice Johnson");
        f1.setMedicalCondition("Cardiac Surgery Required");
        f1.setEstimatedCost(5000.0);
        f1.setRequestedAmount(3000.0);
        f1.setNgoId("NGO001");
        f1.setNgoName("Bangladesh Red Crescent Society");
        f1.setStatus("PENDING");
        fundingService.createFundingRequest(f1);
        
        FundingRequest f2 = new FundingRequest();
        f2.setPatientId(1001L);
        f2.setPatientName("Bob Smith");
        f2.setMedicalCondition("Orthopedic Surgery");
        f2.setEstimatedCost(3200.0);
        f2.setRequestedAmount(2000.0);
        f2.setNgoId("NGO002");
        f2.setNgoName("BRAC Health Program");
        f2.setStatus("APPROVED");
        fundingService.createFundingRequest(f2);
    }
}