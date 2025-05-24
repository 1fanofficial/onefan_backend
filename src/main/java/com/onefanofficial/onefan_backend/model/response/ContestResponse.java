package com.onefanofficial.onefan_backend.model.response;

import com.onefanofficial.onefan_backend.model.data.RaceCalendar;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ContestResponse {
    private UUID id;
    private String contestName;
    private RaceCalendar raceDetails;
    private Double entryFees;
    private Date deadline;
    private String status;
    private int entries;
    private int maxEntries;
    private int prizePool;
    private boolean hasJoined;
}
