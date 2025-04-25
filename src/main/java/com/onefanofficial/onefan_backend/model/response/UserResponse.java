package com.onefanofficial.onefan_backend.model.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String emailId;
    private String phone;
    private String country;

}
