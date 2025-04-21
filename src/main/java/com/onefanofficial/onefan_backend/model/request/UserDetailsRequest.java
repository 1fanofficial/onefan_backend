package com.onefanofficial.onefan_backend.model.request;

import com.onefanofficial.onefan_backend.model.enums.GENDER;
import lombok.Data;

import java.util.Date;

@Data
public class UserDetailsRequest {
    private String id;
    private String firstName;
    private String lastName;
    private Date dob;
    private GENDER gender;
    private String emailId;
    private String phone;
    private String country;
}
