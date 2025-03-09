package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.DoctorDto;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Page<DoctorDto> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable).map(doctor ->
                new DoctorDto(doctor.getId(), doctor.getName(), doctor.getSpecialization(),
                        doctor.getExperience(), doctor.getAvailability(), doctor.getContact()));
    }


    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setAvailability(doctorDto.getAvailability());
        doctor.setContact(doctorDto.getContact());

        Doctor savedDoctor = doctorRepository.save(doctor);
        return new DoctorDto(savedDoctor.getId(), savedDoctor.getName(), savedDoctor.getSpecialization(),
                savedDoctor.getExperience(), savedDoctor.getAvailability(), savedDoctor.getContact());
    }
}
