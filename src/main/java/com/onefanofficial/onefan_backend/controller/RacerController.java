package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.model.response.DriverDetailResponse;
import com.onefanofficial.onefan_backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/racer")
public class RacerController {

    @Autowired
    private DriverService driverService;


    @GetMapping("/all")
    public ResponseEntity<List<DriverDetailResponse>> getAllDrivers(){
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDetailResponse> getAllDrivers(@PathVariable String id){
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

}
