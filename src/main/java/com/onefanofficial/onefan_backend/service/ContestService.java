package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.model.data.Contest;
import com.onefanofficial.onefan_backend.model.data.ContestEntry;
import com.onefanofficial.onefan_backend.model.repository.ContestEntryRepository;
import com.onefanofficial.onefan_backend.model.repository.ContestRepository;
import com.onefanofficial.onefan_backend.model.response.ContestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ContestService {
    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private ContestEntryRepository contestEntryRepository;

    public List<ContestResponse> getContestsByStatus(String userId, String status) {
        List<Contest> contests = contestRepository.findByStatus(status);
        List<ContestResponse> contestResponses = new ArrayList<>();
        contests.forEach(contest -> {
            ContestResponse contestResponse = new ContestResponse();
            contestResponse.setId(contest.getId());
            contestResponse.setContestName(contestResponse.getContestName());
            contestResponse.setDeadline(contest.getDeadline());
            contestResponse.setEntries(contest.getEntries());
            contestResponse.setStatus(contest.getStatus());
            contestResponse.setEntryFees(contestResponse.getEntryFees());
            contestResponse.setMaxEntries(contestResponse.getMaxEntries());
            contestResponse.setRaceName(contest.getRaceDetails().getRaceName());
            contestResponse.setContestName(contest.getContestName());
            contestResponse.setEntryFees(contest.getEntryFees());
            if (!Objects.equals(userId, "anonymousUser")) {
                List<ContestEntry> contestEntries = contestEntryRepository.findByContestIdAndUserId(contest.getId(), UUID.fromString(userId));
                boolean hasJoined = !contestEntries.isEmpty();
                contestResponse.setHasJoined(hasJoined);
            }

            contestResponses.add(contestResponse);
        });

        return contestResponses;
    }
}
