package com.onefanofficial.onefan_backend.model.repository;

import com.onefanofficial.onefan_backend.model.data.ContestEntry;
import com.onefanofficial.onefan_backend.model.data.DriverRankings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRankingRepository extends JpaRepository<DriverRankings, UUID> {
    List<DriverRankings> findByContestEntry(ContestEntry contestEntry);
}
