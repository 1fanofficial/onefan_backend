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
    private UUID id;

    @JoinColumn(name="driver_id")
    @ManyToOne
    private Driver driver;

    @JoinColumn(name = "contest_entry_id")
    @ManyToOne
    private ContestEntry contestEntry;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Column(name="predicted_position")
    private int predictedPosition;

}
