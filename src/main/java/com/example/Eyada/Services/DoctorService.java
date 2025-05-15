package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.DoctorDto;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorDto addDoctor(@NotNull DoctorDto doctorDto) {
        Doctor doctor = Doctor.fromDto(doctorDto);

        Doctor savedDoctor = doctorRepository.save(doctor);

        return new DoctorDto(
                savedDoctor.getId(),
                savedDoctor.getName(),
                savedDoctor.getSpecialization(),
                savedDoctor.getExperience(),
                savedDoctor.getAvailability(),
                savedDoctor.getContact()
        );
    }

    public Optional<DoctorDto> getDoctorById(Long id){
        return doctorRepository.findById(id)
                .map( doctor -> new DoctorDto(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization(),
                        doctor.getExperience(),
                        doctor.getAvailability(),
                        doctor.getContact()
                ));
    }

    public Page<DoctorDto> getAllDoctors(Pageable pageable) {

        return doctorRepository.findAll(pageable)
                .map( doctor -> new DoctorDto(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization(),
                        doctor.getExperience(),
                        doctor.getAvailability(),
                        doctor.getContact()
                        )
                );
    }

    public DoctorDto updateDoctor(DoctorDto doctorDto){
        Doctor doctor = Doctor.fromDto(doctorDto);
        doctor.setId(doctorDto.getId());
        Doctor savedDoctor = doctorRepository.save(doctor);

        return new DoctorDto(
                savedDoctor.getId(),
                savedDoctor.getName(),
                savedDoctor.getSpecialization(),
                savedDoctor.getExperience(),
                savedDoctor.getAvailability(),
                savedDoctor.getContact()
        );
    }

    public Boolean deleteDoctor(Long id){
        if(doctorRepository.findById(id).isPresent()){
            doctorRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
