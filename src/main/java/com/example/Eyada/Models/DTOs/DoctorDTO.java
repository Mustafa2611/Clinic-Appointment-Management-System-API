package com.example.Eyada.Models.DTOs;

import com.example.Eyada.Models.Entities.Patient;
import com.example.Eyada.Models.Entities.Specification;
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
    private Integer Id;

    private String Name ;

    private Specification specification;

}
