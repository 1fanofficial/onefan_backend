package com.onefanofficial.onefan_backend.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ContestEntryRequest {
    private String contestId;
    private List<DriverRankingRequest> driverRankings;
}
