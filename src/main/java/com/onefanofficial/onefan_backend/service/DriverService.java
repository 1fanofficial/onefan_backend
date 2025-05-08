package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions.ResourceNotFoundException;
import com.onefanofficial.onefan_backend.model.data.Driver;
import com.onefanofficial.onefan_backend.model.data.RaceCalendar;
import com.onefanofficial.onefan_backend.model.repository.DriverRepository;
import com.onefanofficial.onefan_backend.model.repository.RaceCalendarRepository;
import com.onefanofficial.onefan_backend.model.repository.RaceDriverRepository;
import com.onefanofficial.onefan_backend.model.response.DriverDetailResponse;
import com.onefanofficial.onefan_backend.util.ConverterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RaceDriverRepository raceDriverRepository;

    @Autowired
    private RaceCalendarRepository raceCalendarRepository;

    public List<DriverDetailResponse> getAllDrivers(){
        return driverRepository.findAll().stream().map(ConverterHelper::convertFromDriver).collect(Collectors.toList());
    }

    public DriverDetailResponse getDriverById(String id){
        UUID uuid = UUID.fromString(id);
        Optional<Driver> driverOptional = driverRepository.findById(uuid);
        if(driverOptional.isPresent()){
            Driver driver = driverOptional.get();
            return ConverterHelper.convertFromDriver(driver);
        }
        throw new ResourceNotFoundException("Driver not found");
    }

    public List<DriverDetailResponse> getDriversByRace(String raceId){
        Optional<RaceCalendar> raceCalendarOptional = raceCalendarRepository.findById(UUID.fromString(raceId));
        if(raceCalendarOptional.isPresent()){
            var raceCalendar = raceCalendarOptional.get();
            return raceDriverRepository.findByRace(raceCalendar).stream()
                    .map(raceDriver ->  ConverterHelper.convertFromDriver(raceDriver.getDriver()))
                    .collect(Collectors.toList());
        }
        throw new ResourceNotFoundException("Race not found");
    }

}
