package com.onefanofficial.onefan_backend.util;

import com.onefanofficial.onefan_backend.model.data.Driver;
import com.onefanofficial.onefan_backend.model.data.RaceCalendar;
import com.onefanofficial.onefan_backend.model.data.Team;
import com.onefanofficial.onefan_backend.model.response.DriverDetailResponse;
import com.onefanofficial.onefan_backend.model.response.RaceResponse;
import com.onefanofficial.onefan_backend.model.response.TeamDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class ConverterHelper {

    public static RaceResponse convertFromRaceCalendarToRaceResponse(RaceCalendar raceCalendar){
        RaceResponse response = new RaceResponse();
        response.setRaceName(raceCalendar.getRaceName());
        response.setId(raceCalendar.getId());
        response.setLaps(raceCalendar.getLaps());
        response.setCountry(raceCalendar.getCountry());
//        response.setFastestLapDriver();
        response.setStatus(raceCalendar.getStatus());
        response.setSeason(raceCalendar.getSeasonId());
        response.setRound(raceCalendar.getRound());
        response.setTrackLength(raceCalendar.getTrackLength());
        response.setCircuitName(raceCalendar.getCircuit());
        response.setQualifyingStartTime(raceCalendar.getQualifyingStartTime());
        response.setSprintStartTime(raceCalendar.getSprintRaceTime());
        response.setRaceStartTime(raceCalendar.getRaceStartTime());

        if(raceCalendar.getWinningDriver() != null){
            response.setRaceWinner(convertFromDriver(raceCalendar.getWinningDriver()));
        }

        if(raceCalendar.getPolePositionDriver() != null){
            response.setPoleDriver(convertFromDriver(raceCalendar.getPolePositionDriver()));
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
        driverDetailResponse.setTeamDetails(convertFromTeam(driver.getTeam()));

        return driverDetailResponse;
    }

    public static TeamDetailResponse convertFromTeam(Team team){
        TeamDetailResponse response = new TeamDetailResponse();

        response.setId(team.getId());
        response.setName(team.getName());
        response.setTeamCode(team.getTeamCode());
        response.setTeamColor(team.getTeamColor());

        return response;
    }

}
