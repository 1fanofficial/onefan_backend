package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions.ResourceNotFoundException;
import com.onefanofficial.onefan_backend.model.data.*;
import com.onefanofficial.onefan_backend.model.repository.ContestEntryRepository;
import com.onefanofficial.onefan_backend.model.repository.ContestRepository;
import com.onefanofficial.onefan_backend.model.repository.DriverRankingRepository;
import com.onefanofficial.onefan_backend.model.repository.UserDetailsRepo;
import com.onefanofficial.onefan_backend.model.request.ContestEntryRequest;
import com.onefanofficial.onefan_backend.model.response.ContestResponse;
import com.onefanofficial.onefan_backend.util.ConverterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContestService {
    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private ContestEntryRepository contestEntryRepository;

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private DriverRankingRepository driverRankingRepository;

    public List<ContestResponse> getContestsByStatus(String userId, String status) {
        List<Contest> contests = contestRepository.findByStatus(status);
        List<ContestResponse> contestResponses = new ArrayList<>();
        var contestEntries = contestEntryRepository.findByUserId(UUID.fromString(userId)).stream().map(ContestEntry::getContest).collect(Collectors.toSet());
        contests.forEach(contest -> {
            var contestResponse = ConverterHelper.convertFromContestToContestResponse(contest);
            if (!Objects.equals(userId, "anonymousUser")) {
                boolean hasJoined = contestEntries.contains(contest);
                contestResponse.setHasJoined(hasJoined);
            }
            contestResponses.add(contestResponse);
        });

        return contestResponses;
    }


    public void joinContest(String userId, ContestEntryRequest contestEntryRequest){
        Optional<Contest> optionalContest = contestRepository.findById(UUID.fromString(contestEntryRequest.getContestId()));

        if(optionalContest.isEmpty()){
            throw new ResourceNotFoundException("Contest Not Found");
        }
        var userDetailsOptional = userDetailsRepo.findById(UUID.fromString(userId));

        if(userDetailsOptional.isEmpty()){
            throw new ResourceNotFoundException("Please update the user Details before proceeding for Contest");
        }

        var contest = optionalContest.get();

        var contestEntry = ConverterHelper.convertToContestEntryEntityFromRequest(userDetailsOptional.get(), contest);
        contestEntry = contestEntryRepository.save(contestEntry);

        List<DriverRankings> driverRankings = new ArrayList<>();
        ContestEntry finalContestEntry = contestEntry;
        contestEntryRequest.getDriverRankings().forEach(driverRankingRequest -> driverRankings.add(ConverterHelper.convertToDriverRankingEntityFromRequest(driverRankingRequest,finalContestEntry)));

        driverRankingRepository.saveAll(driverRankings);

    }
}
