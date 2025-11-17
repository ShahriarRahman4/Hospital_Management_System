package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.PandemicInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PandemicService {
    
    private PandemicInfo pandemicInfo;
    
    public PandemicService() {
        initializePandemicInfo();
    }
    
    private void initializePandemicInfo() {
        pandemicInfo = new PandemicInfo();
        pandemicInfo.setId(1L);
        pandemicInfo.setTitle("Pandemic Emergency Services");
        pandemicInfo.setDescription("Current hospital capacity and resources during pandemic");
        pandemicInfo.setTotalDoctors(150);
        pandemicInfo.setAvailableRooms(45);
        pandemicInfo.setMedicineStock(85);
        pandemicInfo.setEquipmentAvailability("Good");
        pandemicInfo.setLastUpdated(LocalDateTime.now());
    }
    
    public PandemicInfo getPandemicInfo() {
        return pandemicInfo;
    }
    
    public PandemicInfo updatePandemicInfo(PandemicInfo info) {
        info.setLastUpdated(LocalDateTime.now());
        this.pandemicInfo = info;
        return info;
    }
}

