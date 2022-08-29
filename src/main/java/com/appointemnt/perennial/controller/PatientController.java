package com.appointemnt.perennial.controller;

import com.appointemnt.perennial.entity.Patient;
import com.appointemnt.perennial.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/add_patient")
    public ResponseEntity<?> registerUser(@RequestBody @Valid Patient patient) {
        return new ResponseEntity<>(patientService.registerPatient(patient), HttpStatus.CREATED);
    }
}
