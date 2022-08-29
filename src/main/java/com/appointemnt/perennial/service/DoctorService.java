package com.appointemnt.perennial.service;

import com.appointemnt.perennial.entity.Doctor;
import com.appointemnt.perennial.entity.User;


import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctorsBySpeciality(String searchTerm);

    List<Doctor> getDoctorsByDisplayName(String searchTerm,String role);

    List<Doctor> getDoctorsByRegion(String region,String role);

    Doctor updateDoctorMobile(User user,Long id);

    Doctor updateDoctorEmail(User user,Long id);

    Doctor updateDoctorRegion(User user,Long id);

    Doctor registerDoctor(Doctor doctor);
}
