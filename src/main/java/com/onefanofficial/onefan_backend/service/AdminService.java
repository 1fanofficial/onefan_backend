package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.model.data.Contest;
import com.onefanofficial.onefan_backend.model.data.ContestEntry;
import com.onefanofficial.onefan_backend.model.data.DriverRankings;
import com.onefanofficial.onefan_backend.model.data.RaceDriver;
import com.onefanofficial.onefan_backend.model.repository.ContestEntryRepository;
import com.onefanofficial.onefan_backend.model.repository.ContestRepository;
import com.onefanofficial.onefan_backend.model.repository.DriverRankingRepository;
import com.onefanofficial.onefan_backend.model.repository.RaceDriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private ContestEntryRepository contestEntryRepository;

    @Autowired
    private DriverRankingRepository driverRankingRepository;

    @Autowired
    private RaceDriverRepository raceDriverRepository;

    @Autowired
    private ContestRepository contestRepository;

    /**
     * Calculates the points for each contest entry and updates the leaderboard
     * rankings for the contest
     *
     * @param contestId of the contest
     */
    @Transactional
    public void updateLeaderboard(String contestId) {
        try {
            Contest contest = contestRepository.findById(UUID.fromString(contestId))
                    .orElseThrow(() -> new RuntimeException("Contest not found"));

            List<ContestEntry> contestEntries = contestEntryRepository.findByContest(contest);
            List<RaceDriver> raceDrivers = raceDriverRepository.findByRace(contest.getRaceDetails());

            Map<UUID, RaceDriver> raceDriverMap = raceDrivers.stream()
                    .collect(Collectors.toMap(RaceDriver::getId, Function.identity()));

            contestEntries.forEach(contestEntry -> {
                // for each contest entry get the predicted finish position list of drivers
                List<DriverRankings> driverRankings = driverRankingRepository.findByContestEntry(contestEntry);
                int totalPoints = 0;
                for (DriverRankings driverRanking : driverRankings) {
                    UUID driverId = driverRanking.getRaceDriver().getId();
                    RaceDriver actualDriver = raceDriverMap.get(driverId);

                    if (actualDriver == null) {
                        throw new RuntimeException("Race driver not found: " + driverId);
                    }

                    if (!"FINISHED".equals(actualDriver.getFinishStatus())) {
                        continue;
                    }

                    int predictedFinishPosition = driverRanking.getPredictedPosition();
                    int actualFinishPosition = actualDriver.getFinishPosition();

                    // add 5 points for correct prediction
                    if (predictedFinishPosition == actualFinishPosition) {
                        totalPoints += 5;
                    } else {
                        // deduct the difference of actual position and predicted position
                        int difference = Math.abs(predictedFinishPosition - actualFinishPosition);
                        totalPoints -= difference;
                    }

                    // add 10 points for correct prediction of fastest lap driver
                    if(contestEntry.getFastestLapDriver().getId().equals(contest.getRaceDetails().getFastestLapDriver().getId())){
                        totalPoints += 10;
                    }
                }

                contestEntry.setPoints(totalPoints);
                contestEntryRepository.save(contestEntry);

                System.out.println("ContestEntry ID: " + contestEntry.getId() + " → Total Points: " + totalPoints);
            });
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
