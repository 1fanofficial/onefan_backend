package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.model.response.RaceResponse;
import com.onefanofficial.onefan_backend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @GetMapping("/all")
    public ResponseEntity<List<RaceResponse>> getAllRace(){
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaceResponse> getRaceById(@PathVariable String id){
        return ResponseEntity.ok(raceService.getRaceById(id));
    }

}
