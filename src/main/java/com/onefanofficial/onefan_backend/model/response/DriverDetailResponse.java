package com.onefanofficial.onefan_backend.model.response;

import lombok.Data;

import java.util.UUID;

@Data
public class DriverDetailResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String driverCode;
    private int carNumber;
    private String status;
    private String nationality;
    private TeamDetailResponse team;
}
