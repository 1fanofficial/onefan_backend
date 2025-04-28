package com.onefanofficial.onefan_backend.model.data;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="driver")
@Data
public class Driver {
    @Column(name = "id")
    @Id
    private UUID id;

    @Column(name = "dob")
    private Date dob;

    @Column(name="driver_code")
    private String driverCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @JoinColumn(name="team_id")
    @ManyToOne
    private Team team;

    @Column(name = "car_number")
    private int carNumber;

    @Column(name="status")
    private String status;

}
