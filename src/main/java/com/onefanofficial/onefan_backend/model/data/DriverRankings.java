package com.onefanofficial.onefan_backend.model.data;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="driver_rankings")
@Data
public class DriverRankings {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name="race_driver_id")
    @ManyToOne
    private RaceDriver raceDriver;

    @JoinColumn(name = "contest_entry_id")
    @ManyToOne
    private ContestEntry contestEntry;

    @Column(name="predicted_position")
    private int predictedPosition;
}
