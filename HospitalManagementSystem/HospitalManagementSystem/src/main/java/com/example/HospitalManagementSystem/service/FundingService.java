package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.FundingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class FundingService {
    
    private final Map<Long, FundingRequest> fundingRequests = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    
    public FundingRequest createFundingRequest(FundingRequest request) {
        Long id = idCounter.getAndIncrement();
        request.setId(id);
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());
        fundingRequests.put(id, request);
        return request;
    }
    
    public List<FundingRequest> getPatientFundingRequests(Long patientId) {
        return fundingRequests.values().stream()
            .filter(f -> f.getPatientId().equals(patientId))
            .collect(Collectors.toList());
    }
    
    public List<FundingRequest> getAllFundingRequests() {
        return new ArrayList<>(fundingRequests.values());
    }
    
    public FundingRequest approveFundingRequest(Long id, String adminNotes) {
        FundingRequest request = fundingRequests.get(id);
        if (request != null) {
            request.setStatus("APPROVED");
            request.setAdminNotes(adminNotes);
            request.setApprovedAt(LocalDateTime.now());
        }
        return request;
    }
    
    public FundingRequest rejectFundingRequest(Long id, String adminNotes) {
        FundingRequest request = fundingRequests.get(id);
        if (request != null) {
            request.setStatus("REJECTED");
            request.setAdminNotes(adminNotes);
        }
        return request;
    }
    
    public boolean transferFundsToBank(Long id) {
        FundingRequest request = fundingRequests.get(id);
        if (request != null && "APPROVED".equals(request.getStatus())) {
            request.setStatus("FUNDED");
            // In a real system, this would trigger a bank transfer
            return true;
        }
        return false;
    }
    
    public List<Map<String, String>> getNGOs() {
        List<Map<String, String>> ngos = new ArrayList<>();
        ngos.add(Map.of("id", "NGO001", "name", "Bangladesh Red Crescent Society"));
        ngos.add(Map.of("id", "NGO002", "name", "BRAC Health Program"));
        ngos.add(Map.of("id", "NGO003", "name", "Save the Children"));
        ngos.add(Map.of("id", "NGO004", "name", "World Vision Bangladesh"));
        ngos.add(Map.of("id", "NGO005", "name", "ActionAid Bangladesh"));
        return ngos;
    }
}
