package com.onefanofficial.onefan_backend.model.data;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "contest")
public class Contest {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="contest_name")
    private String contestName;

    @Column(name="entry_fees")
    private Double entryFees;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="status")
    private String status;

    @Column(name="entries")
    private int entries;

    @Column(name="max_entries")
    private int maxEntries;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name="created_by")
    private String createdBy;

    @JoinColumn(name ="race_id")
    @ManyToOne
    private RaceCalendar raceId;

    @JoinColumn(name ="winner")
    @ManyToOne
    private Driver winner;

    @Column(name="entry_fees_currency")
    private String entryFeesCurrency;

}
