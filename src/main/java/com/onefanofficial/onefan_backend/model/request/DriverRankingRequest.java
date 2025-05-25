package com.onefanofficial.onefan_backend.model.request;

import lombok.Data;

@Data
public class DriverRankingRequest {
    private String driverId;
    private int predictedPosition;
}
