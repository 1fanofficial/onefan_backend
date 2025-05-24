package com.onefanofficial.onefan_backend.model.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="team")
public class Team {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="team_code")
    private String teamCode;

    @Column(name="team_color")
    private String teamColor;

    @Column(name="gradientOne")
    private String gradientOne;

    @Column(name="gradientTwo")
    private String gradientTwo;

    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

}
