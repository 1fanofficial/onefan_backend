package com.onefanofficial.onefan_backend.util;

import com.onefanofficial.onefan_backend.model.data.*;
import com.onefanofficial.onefan_backend.model.request.DriverRankingRequest;
import com.onefanofficial.onefan_backend.model.response.ContestResponse;
import com.onefanofficial.onefan_backend.model.response.DriverDetailResponse;
import com.onefanofficial.onefan_backend.model.response.RaceResponse;
import com.onefanofficial.onefan_backend.model.response.TeamDetailResponse;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ConverterHelper {

    public static RaceResponse convertFromRaceCalendarToRaceResponse(RaceCalendar raceCalendar){
        RaceResponse response = new RaceResponse();
        response.setRaceName(raceCalendar.getRaceName());
        response.setId(raceCalendar.getId());
        response.setLaps(raceCalendar.getLaps());
        response.setCountry(raceCalendar.getCountry());
        response.setStatus(raceCalendar.getStatus());
        response.setSeason(raceCalendar.getSeason());
        response.setRound(raceCalendar.getRound());
        response.setTrackLength(raceCalendar.getTrackLength());
        response.setCircuitName(raceCalendar.getCircuitName());
        response.setQualifyingStartTime(raceCalendar.getQualifyingStartTime());
        response.setSprintStartTime(raceCalendar.getSprintStartTime());
        response.setRaceStartTime(raceCalendar.getRaceStartTime());

        if(raceCalendar.getRaceWinner() != null){
            response.setRaceWinner(convertFromDriver(raceCalendar.getRaceWinner()));
        }

        if(raceCalendar.getPoleDriver() != null){
            response.setPoleDriver(convertFromDriver(raceCalendar.getPoleDriver()));
        }


        if(raceCalendar.getFastestLapDriver() != null){
            response.setFastestLapDriver(convertFromDriver(raceCalendar.getFastestLapDriver()));
        }

        return response;

    }

    public static DriverDetailResponse convertFromDriver(Driver driver){
        DriverDetailResponse driverDetailResponse = new DriverDetailResponse();
        driverDetailResponse.setId(driver.getId());
        driverDetailResponse.setFirstName(driver.getFirstName());
        driverDetailResponse.setLastName(driver.getLastName());
        driverDetailResponse.setCarNumber(driver.getCarNumber());
        driverDetailResponse.setDriverCode(driver.getDriverCode());
        driverDetailResponse.setStatus(driver.getStatus());
        driverDetailResponse.setNationality(driver.getNationality());
        driverDetailResponse.setTeam(convertFromTeam(driver.getTeam()));

        return driverDetailResponse;
    }

    public static TeamDetailResponse convertFromTeam(Team team){
        TeamDetailResponse response = new TeamDetailResponse();

        response.setId(team.getId());
        response.setName(team.getName());
        response.setTeamCode(team.getTeamCode());
        response.setTeamColor(team.getTeamColor());
        response.setGradientOne(team.getGradientOne());
        response.setGradientTwo(team.getGradientTwo());

        return response;
    }

    public static ContestResponse convertFromContestToContestResponse(Contest contest){
        ContestResponse contestResponse = new ContestResponse();
        contestResponse.setId(contest.getId());
        contestResponse.setContestName(contestResponse.getContestName());
        contestResponse.setDeadline(contest.getDeadline());
        contestResponse.setEntries(contest.getEntries());
        contestResponse.setStatus(contest.getStatus());
        contestResponse.setEntryFees(contestResponse.getEntryFees());
        contestResponse.setMaxEntries(contestResponse.getMaxEntries());
        contestResponse.setRaceDetails(contest.getRaceDetails());
        contestResponse.setContestName(contest.getContestName());
        contestResponse.setEntryFees(contest.getEntryFees());

        return contestResponse;
    }

    public static ContestEntry convertToContestEntryEntityFromRequest(UserDetails userDetails,Contest contest, RaceDriver fastestLapDriver){
        ContestEntry contestEntry = new ContestEntry();
        contestEntry.setContest(contest);
        contestEntry.setUserDetails(userDetails);
        contestEntry.setFastestLapDriver(fastestLapDriver);

        return contestEntry;
    }

    public static DriverRankings convertToDriverRankingEntityFromRequest(RaceDriver raceDriver, int predictedPosition, ContestEntry contestEntry){
        DriverRankings driverRanking = new DriverRankings();
        driverRanking.setContestEntry(contestEntry);
        driverRanking.setPredictedPosition(predictedPosition);
        driverRanking.setRaceDriver(raceDriver);

        return driverRanking;
    }
}
