package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.PatientDto;
import com.example.Eyada.Models.Entities.Patient;
import com.example.Eyada.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> new PatientDto(patient.getId(), patient.getName(), patient.getEmail(),
                        patient.getContact(), patient.getAge(), patient.getMedicalHistory()))
                .collect(Collectors.toList());
    }

    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setContact(patientDto.getContact());
        patient.setAge(patientDto.getAge());
        patient.setMedicalHistory(patientDto.getMedicalHistory());

        Patient savedPatient = patientRepository.save(patient);
        return new PatientDto(savedPatient.getId(), savedPatient.getName(), savedPatient.getEmail(),
                savedPatient.getContact(), savedPatient.getAge(), savedPatient.getMedicalHistory());
    }
}
