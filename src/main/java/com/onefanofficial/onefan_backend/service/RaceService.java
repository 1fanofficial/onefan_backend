package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions.ResourceNotFoundException;
import com.onefanofficial.onefan_backend.model.data.RaceCalendar;
import com.onefanofficial.onefan_backend.model.repository.RaceCalendarRepository;
import com.onefanofficial.onefan_backend.model.response.RaceResponse;
import com.onefanofficial.onefan_backend.util.ConverterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RaceService {

    @Autowired
    private RaceCalendarRepository raceCalendarRepository;

    public List<RaceResponse> getAllRaces(){
        List<RaceCalendar>  raceCalendars = raceCalendarRepository.findAll();
        raceCalendars.sort(Comparator.comparingInt(RaceCalendar::getRound));
        List<RaceResponse> response = new ArrayList<>();

        raceCalendars.forEach(raceCalendar -> {
            response.add( ConverterHelper.convertFromRaceCalendarToRaceResponse(raceCalendar));
        });

        return response;
    }

    public RaceResponse getRaceById(String id){
        Optional<RaceCalendar> raceCalendar = raceCalendarRepository.findById(UUID.fromString(id));
        if(raceCalendar.isPresent()){
            return ConverterHelper.convertFromRaceCalendarToRaceResponse(raceCalendar.get());
        }
        throw new ResourceNotFoundException("Race not found");
    }
}
