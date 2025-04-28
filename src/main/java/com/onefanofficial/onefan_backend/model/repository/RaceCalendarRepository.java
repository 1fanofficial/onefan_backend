package com.onefanofficial.onefan_backend.model.repository;

import com.onefanofficial.onefan_backend.model.data.RaceCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RaceCalendarRepository extends JpaRepository<RaceCalendar, UUID> {

}
