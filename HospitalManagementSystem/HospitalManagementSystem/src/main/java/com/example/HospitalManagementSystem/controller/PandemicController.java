package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.PandemicInfo;
import com.example.HospitalManagementSystem.service.PandemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pandemic")
@CrossOrigin("*")
public class PandemicController {
    
    @Autowired
    private PandemicService pandemicService;
    
    @GetMapping
    public ResponseEntity<PandemicInfo> getPandemicInfo() {
        return ResponseEntity.ok(pandemicService.getPandemicInfo());
    }
    
    @PutMapping
    public ResponseEntity<PandemicInfo> updatePandemicInfo(@RequestBody PandemicInfo info) {
        PandemicInfo updated = pandemicService.updatePandemicInfo(info);
        return ResponseEntity.ok(updated);
    }
}

