package com.appointemnt.perennial.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private long id;
    private String dateOfBirth;
    private String bloodGroup;
    private String email;
    private String mobile;
    private String displayName;
    private String region;
    private String role;
}
