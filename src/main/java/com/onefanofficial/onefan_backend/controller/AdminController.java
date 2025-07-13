package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/{contestId}/updateLeaderboard")
    public ResponseEntity<?> updateContestLeaderboard(@PathVariable String contestId) {
        adminService.updateLeaderboard(contestId);
        return ResponseEntity.ok("Leaderboard updated successfully");
    }
}
