package com.onefanofficial.onefan_backend.model.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class RaceResponse {
    private UUID id;
    private int season;
    private int round;
    private String raceName;
    private String circuitName;
    private int laps;
    private Float trackLength;
    private String country;
    private Date qualifyingStartTime;
    private Date sprintStartTime;
    private Date raceStartTime;
    private DriverDetailResponse poleDriver;
    private DriverDetailResponse fastestLapDriver;
    private DriverDetailResponse raceWinner;
    private String status;
}
