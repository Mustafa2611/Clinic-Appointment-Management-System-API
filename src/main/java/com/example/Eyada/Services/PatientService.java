package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.PatientDto;
import com.example.Eyada.Models.Entities.Patient;
import com.example.Eyada.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
//    private final ModelMapper modelmapper;

    public PatientDto addPatient(@NotNull PatientDto patientDto) {
        Patient patient = Patient.fromDto(patientDto);

        Patient savedPatient = patientRepository.save(patient);
        return new PatientDto(
                savedPatient.getId(),
                savedPatient.getName(),
                savedPatient.getEmail(),
                savedPatient.getContact(),
                savedPatient.getAge(),
                savedPatient.getMedicalHistory()
        );
    }


    public Page<PatientDto> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable)
                .map( patient -> new PatientDto(
                                patient.getId(),
                                patient.getName(),
                                patient.getEmail(),
                                patient.getContact(),
                                patient.getAge(),
                                patient.getMedicalHistory()
                        )
                );
    }




    public PatientDto updatePatient(@NotNull PatientDto patientDto){
        Patient patient = Patient.fromDto(patientDto);
        patient.setId(patient.getId());
        Patient savedPatient = patientRepository.save(patient);
        return new PatientDto(
                savedPatient.getId(),
                savedPatient.getName(),
                savedPatient.getEmail(),
                savedPatient.getContact(),
                savedPatient.getAge(),
                savedPatient.getMedicalHistory()
        );
    }

    public Boolean deletePatient(Long id){
        if(patientRepository.findById(id).isPresent()){
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
