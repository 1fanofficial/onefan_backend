package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.model.response.DriverDetailResponse;
import com.onefanofficial.onefan_backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/all")
    public ResponseEntity<List<DriverDetailResponse>> getAllDrivers(@RequestParam(required = false, name = "raceId") String raceId) {
        if (raceId != null) {
            return ResponseEntity.ok(driverService.getDriversByRace(raceId));
        }
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDetailResponse> getDriverById(@PathVariable String id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    @GetMapping("/by-race/{raceId}")
    public ResponseEntity<List<DriverDetailResponse>> getDriversByRace(@PathVariable String raceId) {
        return ResponseEntity.ok(driverService.getDriversByRace(raceId));
    }
}
