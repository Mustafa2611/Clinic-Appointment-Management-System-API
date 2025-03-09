package com.example.Eyada.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDto {
    private Long id;
    private String name;
    private String specialization;
    private int experience;
    private String availability;
    private String contact;
}
