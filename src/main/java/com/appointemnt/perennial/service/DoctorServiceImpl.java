package com.appointemnt.perennial.service;

import com.appointemnt.perennial.dao.DoctorRepository;
import com.appointemnt.perennial.dao.UserRepository;
import com.appointemnt.perennial.entity.Doctor;
import com.appointemnt.perennial.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
@Autowired
    private UserRepository userRepository;
    @Override
    public List<Doctor> getDoctorsBySpeciality(String searchTerm) {
        List<Doctor> doctorList = doctorRepository.findAllBySpecialityContainsIgnoreCase(searchTerm);
        if(doctorList.isEmpty()){
          throw new RuntimeException("no such doctors by this speaciality");
        }
        return doctorList;
    }

    @Override
    public List<Doctor> getDoctorsByDisplayName(String searchTerm, String role) {
        List<Doctor> doctors = doctorRepository.findAllByUserDisplayNameContainsIgnoreCaseAndUserRole(searchTerm,role);
        if(doctors.isEmpty()){
            throw new RuntimeException("no such doctors by this name");
        }
        return doctors;
    }

    @Override
    public List<Doctor> getDoctorsByRegion(String region,String role) {
        List<Doctor> doctors = doctorRepository.findAllByUserRegionAndUserRole(region,role);
        if (doctors.isEmpty()){
            throw new RuntimeException("no doctors by this region");
        }
        return doctors;
    }


    @Override
    public Doctor updateDoctorMobile(User user,Long id) {
        Doctor doctor1 = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("no such resource by id "));
        User user1  =   doctor1.getUser();
        user1.setMobile(user.getMobile());
        return doctorRepository.save(doctor1);
    }

    @Override
    public Doctor updateDoctorEmail(User user, Long id) {
        Doctor doctor1 = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("no such resource by id "));
        User user1  =   doctor1.getUser();
        user1.setEmail(user.getEmail());
        return doctorRepository.save(doctor1);
    }

    @Override
    public Doctor updateDoctorRegion(User user, Long id) {
        Doctor doctor1 = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("no such resource by id "));
            User user1  =   doctor1.getUser();
            user1.setRegion(user.getRegion());
        return doctorRepository.save(doctor1);
    }

    @Override
    public Doctor  registerDoctor(Doctor doctor) {
       return doctorRepository.save(doctor);
    }
}
