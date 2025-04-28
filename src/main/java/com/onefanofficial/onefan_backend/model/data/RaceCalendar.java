package com.onefanofficial.onefan_backend.model.data;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "race_calendar")
@Data
public class RaceCalendar {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "season")
    private int seasonId; // for now this is year only

    @Column(name = "round")
    private int round;

    @Column(name = "race_name")
    private String raceName;

    @Column(name = "circuit_name")
    private String circuit;

    @Column(name = "country")
    private String country;

    @Column(name="race_start_time")
    private Date raceStartTime;

    @Column(name="laps")
    private int laps;

    @Column(name="track_length")
    private Float trackLength;

    @JoinColumn(name="pole_driver_id")
    @ManyToOne
    private Driver polePositionDriver;

    @JoinColumn(name="fastest_lap_driver_id")
    @ManyToOne
    private Driver fastestLapDriver;

    @JoinColumn(name="winning_driver_id")
    @ManyToOne
    private Driver winningDriver;

    @Column(name="status")
    private String status;

    @Column(name="qualifying_start_time")
    private Date qualifyingStartTime;

    @Column(name="sprint_start_time")
    private Date sprintRaceTime;

    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updated_at")
    @CreationTimestamp
    private Date updatedAt;

}
