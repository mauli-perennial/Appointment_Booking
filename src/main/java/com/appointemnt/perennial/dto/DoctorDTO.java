package com.appointemnt.perennial.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private long id;
    private String education;
    private Integer experience;
    private String speciality;
    private String email;
    private String mobile;
    private String displayName;
    private String region;
    private String role;
}
