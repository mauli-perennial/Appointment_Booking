package com.appointemnt.perennial.controller;

import com.appointemnt.perennial.dto.DoctorDTO;
import com.appointemnt.perennial.dto.UserDTO;
import com.appointemnt.perennial.entity.Doctor;
import com.appointemnt.perennial.entity.User;
import com.appointemnt.perennial.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/find_by_speciality/{speciality}")
    public List<DoctorDTO> getDoctorsBySpeciality(@PathVariable String speciality) {
        if (speciality.isBlank()) {
            throw new RuntimeException("searchTerm should not be blank");
        }
        return doctorService.getDoctorsBySpeciality(speciality).stream().map(doc -> modelMapper.map(doc, DoctorDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/find_by_name/{name}/{role}")
    public List<DoctorDTO> getDoctorsByName(@PathVariable String name, @PathVariable String role) {
        if (name.isBlank()) {
            throw new RuntimeException("searchTerm should not be blank");
        }
        return doctorService.getDoctorsByDisplayName(name, role).stream().map(doctor -> modelMapper.map(doctor, DoctorDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/find_by_region/{region}/{role}")
    public List<DoctorDTO> getDoctorsByRegion(@PathVariable String region, @PathVariable String role) {
        if (region.isBlank()) {
            throw new RuntimeException("searchTerm should not be blank");
        }
        return doctorService.getDoctorsByRegion(region, role).stream().map(doctor -> modelMapper.map(doctor, DoctorDTO.class)).collect(Collectors.toList());
    }

    @PutMapping("/update_mobile/{id}")
    public ResponseEntity<DoctorDTO> updateDoctorMobile(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        Doctor doctor1 = doctorService.updateDoctorEmail(user, id);
        DoctorDTO doctorDTO = modelMapper.map(doctor1, DoctorDTO.class);
        return ResponseEntity.ok(doctorDTO);
    }

    @PutMapping("/update_email/{id}")
    public ResponseEntity<DoctorDTO> updateDoctorEmail(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        Doctor doctor1 = doctorService.updateDoctorEmail(user, id);
        DoctorDTO doctorDTO = modelMapper.map(doctor1, DoctorDTO.class);
        return ResponseEntity.ok(doctorDTO);
    }

    @PutMapping("/update_region/{id}")
    public ResponseEntity<DoctorDTO> updateDoctorRegion(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        Doctor doctor1 = doctorService.updateDoctorRegion(user, id);
        DoctorDTO doctorDTO = modelMapper.map(doctor1, DoctorDTO.class);
        return ResponseEntity.ok(doctorDTO);
    }

    @PostMapping("/add_doctor")
    public ResponseEntity<?> registerUser(@RequestBody @Valid Doctor doctor) {
        Doctor doctor1 = doctorService.registerDoctor(doctor);
        DoctorDTO doctorDTO = modelMapper.map(doctor1, DoctorDTO.class);
        return new ResponseEntity<>(doctorDTO, HttpStatus.CREATED);
    }
}

