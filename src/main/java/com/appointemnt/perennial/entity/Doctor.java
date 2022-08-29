package com.appointemnt.perennial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends User {
    @Column(length = 20)
    @NotBlank(message = "speciality is required")
    @NotNull
    private String speciality;

    @NotNull
    private Integer experience;

    @Column(length = 20)
    @NotBlank(message = "Education is required")
    @NotNull
    private String education;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User user;
}
