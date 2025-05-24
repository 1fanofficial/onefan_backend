package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.model.data.RaceDriver;
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

    @GetMapping("/{id}")
    public ResponseEntity<DriverDetailResponse> getDriverById(@PathVariable String id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    @GetMapping("/by-race/{raceId}")
    public ResponseEntity<List<RaceDriver>> getDriversByRace(@PathVariable String raceId) {
        return driverService.getDriversByRace(raceId);
    }
}
