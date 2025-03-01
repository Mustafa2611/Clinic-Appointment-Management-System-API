package com.example.Eyada.Models.DTOs;

import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Models.Entities.Patient;
import com.example.Eyada.Models.Entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDTO {
    private Long Id;

    private String Name ;

//    private Specification specification;

    public static DoctorDTO toDTO(User entity){
        return DoctorDTO.builder().
                Id(entity.getId()).
                Name(entity.getName()).
//                specification(entity.getSpecification()).
                build();
    }
}
