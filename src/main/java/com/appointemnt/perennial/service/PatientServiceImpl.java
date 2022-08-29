package com.appointemnt.perennial.service;

import com.appointemnt.perennial.dao.PatientRepository;
import com.appointemnt.perennial.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public String registerPatient(Patient patient) {
        patientRepository.save(patient);
        return "patient registered successfully ";
    }
}
