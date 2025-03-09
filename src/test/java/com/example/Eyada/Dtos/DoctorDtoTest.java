package com.example.Eyada.Dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDtoTest {
    private Long id;
    private String name;
    private String specialization;
    private int experience;
    private String availability;
    private String contact;
}