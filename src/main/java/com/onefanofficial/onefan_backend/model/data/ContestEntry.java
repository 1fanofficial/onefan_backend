package com.onefanofficial.onefan_backend.model.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name="contest_entry")
@Data
public class ContestEntry {
    @Column(name = "id")
    @Id
    private UUID id;

    @JoinColumn(name = "contest_id")
    @ManyToOne
    private Contest contest;

    @JoinColumn(name = "user_id")
    @OneToOne
    private UserDetails userDetails;

    @Column(name = "points")
    private int points;

    @Column(name = "rank")
    private int rank;
}
