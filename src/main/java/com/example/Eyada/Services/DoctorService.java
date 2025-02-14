package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.DoctorDTO;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Repositories.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor Add(DoctorDTO doctorDTO){
        Doctor doctor = Doctor.builder().
                Name(doctorDTO.getName()).
                specification(doctorDTO.getSpecification()).
                build();
        doctorRepo.save(doctor);
        return doctor;
    }

    public Doctor GetById(Integer id){
        Optional<Doctor> doctor = doctorRepo.findById(id);
        return doctor.orElse(null);
    }

    public List<Doctor> GetAll(){
        List<Doctor> doctors = doctorRepo.findAll();
        if(doctors.isEmpty())
            return null;
        else
            return doctors;
    }

    public Doctor Update(DoctorDTO doctorDTO){
        Doctor doctor = Doctor.builder().
                Id(doctorDTO.getId()).
                Name(doctorDTO.getName()).
                specification(doctorDTO.getSpecification()).
                build();
        if(doctor!=null)
            doctorRepo.save(doctor);
        return doctor;
    }

    public void Delete(Integer id){
        boolean doctor_exist = doctorRepo.existsById(id);
        if (doctor_exist)
            doctorRepo.deleteById(id);
        else
            return;
    }
}
