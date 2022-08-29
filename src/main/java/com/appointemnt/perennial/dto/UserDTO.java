package com.appointemnt.perennial.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String displayName;
    private String email;
    private Long mobile;
    private String role;
    private String region;
}
