package com.onefanofficial.onefan_backend.model.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ContestResponse {
    private UUID id;
    private String contestName;
    private String RaceName;
    private Double entryFees;
    private Date deadline;
    private String status;
    private int entries;
    private int maxEntries;
    private int prizePool;
    private boolean hasJoined;
}
