package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.PatientDTO;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Models.Entities.Patient;
import com.example.Eyada.Repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient Add(PatientDTO patientDTO){
        Patient patient = Patient.builder().
                Name(patientDTO.getName()).
                Age(patientDTO.getAge()).
                build();
        return patientRepo.save(patient);
    }

    public Patient GetById(Integer id){
        Optional<Patient> patient = patientRepo.findById(id);
        return patient.orElse(null);
    }

    public List<Patient> GetAll(){
        return patientRepo.findAll();
    }

    public Patient Update(PatientDTO patientDTO){
        Patient patient = Patient.builder().
                Id(patientDTO.getId()).
                Name(patientDTO.getName()).
                Age(patientDTO.getAge()).
                build();
        return patientRepo.save(patient);
    }

    public void Delete(Integer id){
        if(patientRepo.existsById(id))
            patientRepo.deleteById(id);
        else
            return;

    }
}
