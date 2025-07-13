package com.onefanofficial.onefan_backend.model.repository;

import com.onefanofficial.onefan_backend.model.data.Contest;
import com.onefanofficial.onefan_backend.model.data.ContestEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ContestEntryRepository extends JpaRepository<ContestEntry, UUID> {
    @Query("SELECT e FROM ContestEntry e WHERE e.contest.id = :contestId AND e.userDetails.id = :userId")
    List<ContestEntry> findByContestIdAndUserId(UUID contestId, UUID userId);

    @Query("SELECT e FROM ContestEntry e where e.userDetails.id = :userId")
    List<ContestEntry> findByUserId(UUID userId);

    @Query("SELECT COUNT(e) FROM ContestEntry e WHERE e.contest = :contest")
    int findCountByContest(Contest contest);

    List<ContestEntry> findByContest(Contest contest);
}
