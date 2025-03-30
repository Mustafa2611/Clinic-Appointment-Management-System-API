package com.example.Eyada.Models.Entities;

import com.example.Eyada.Models.DTOs.PatientDto;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name = "contact",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contact;
    @Column(
            name = "age",
            nullable = false
    )
    private int age;
    @Column(name = "medical_history")
    private String medicalHistory; // Optional

    public Patient(String name, String email, String contact, int age, String medicalHistory) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.contact = contact;
        this.medicalHistory = medicalHistory;
    }

    public static Patient fromDto(PatientDto dto) {
        return new Patient(
                dto.getName(),
                dto.getEmail(),
                dto.getContact(),
                dto.getAge(),
                dto.getMedicalHistory()
        );
    }
}
