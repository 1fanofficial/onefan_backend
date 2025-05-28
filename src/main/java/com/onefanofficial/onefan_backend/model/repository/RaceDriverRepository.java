package com.onefanofficial.onefan_backend.model.repository;

import com.onefanofficial.onefan_backend.model.data.RaceCalendar;
import com.onefanofficial.onefan_backend.model.data.RaceDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RaceDriverRepository extends JpaRepository<RaceDriver, UUID> {
    List<RaceDriver> findByRace(RaceCalendar raceCalendar);

    @Query("SELECT rd FROM RaceDriver rd WHERE (rd.race.id = :raceId AND rd.driver.id = :driverId)")
    RaceDriver findByRaceAndDriver(UUID raceId, UUID driverId);
}
