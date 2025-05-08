package com.onefanofficial.onefan_backend.model.data;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "race_driver")
@Data
public class RaceDriver {

    @Id
    @Column(name = "id")
    private UUID id;

    @JoinColumn(name="driver_id")
    @ManyToOne
    private Driver driver;

    @JoinColumn(name = "race_id")
    @ManyToOne
    private RaceCalendar race;

    @Column(name="finish_position")
    private int finishPosition;

    @Column(name="grid_position")
    private int gridPosition;

    @Column(name="pit_stops")
    private int pitStops;

    @Column(name="status")
    private String status;

    @Column(name="laps_completed")
    private int lapsCompleted;

    @Column(name="overtakes")
    private int overtakes;

    @Column(name="points_earned")
    private int pointsEarned;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

}
