package com.onefanofficial.onefan_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/healthCheck")
    public ResponseEntity<String> getAppStatus(){
        return ResponseEntity.ok("OK");
    }
}
