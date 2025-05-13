package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.configuration.annotations.CustomUser.CurrentUser;
import com.onefanofficial.onefan_backend.model.response.ContestResponse;
import com.onefanofficial.onefan_backend.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContestController {
    @Autowired
    private ContestService contestService;

    @GetMapping("/getContestByStatus")
    public ResponseEntity<List<ContestResponse>> getContestByStatus(@CurrentUser String userId, @RequestParam String status){
        return ResponseEntity.ok(contestService.getContestsByStatus(userId, status));
    }
}
